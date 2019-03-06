package Scenes;

import Controllers.KeyController;
import Controllers.MenubarControllers.LoadLocalController;
import Controllers.MenubarControllers.LoadServerController;
import Controllers.MenubarControllers.SaveLocalController;
import Controllers.MenubarControllers.SaveServerController;
import Controllers.UpgradeController;
import GameLogic.*;
import Graphics.*;
import THutil.FileIO.SaveDataExtractor;
import THutil.WordLoader;
import GameLogic.Upgrades.HealUpgrade;
import GameLogic.Upgrades.PointsPerLetterUpgrade;
import GameLogic.Upgrades.PointsPerSecondUpgrade;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;


public class SinglePlayer {

     private BorderPane mainWindow;
     private static Timeline pointsPerSecTimeline;
     private static Timeline damagePerSecTimeline;

    /**
     * Konstruktorn för SinglePlayer, skapar och startar allt som behövs i SinglePlayer
     * (Handlers,grafikPaneler,kontroller och Datakapslar
     * @param username används som inparameter till spara och ladda metoder
     */
    public SinglePlayer(String username){
        WordLoader loader = new WordLoader();

        // CREATES HANDLER
        PointHandler pointhandler = new PointHandler();
        HealthHandler healthhandler = new HealthHandler(100,100);
        WordHandler wordhandler = new WordHandler(loader.loadWords(),pointhandler, healthhandler);
        UpgradeHandler upgradehandler = new UpgradeHandler();

        //CREATE TIMER
        startTimeLines(pointhandler,healthhandler);

        // CREATE DATAEXTRACTOR
        SaveDataExtractor savedataextractor = new SaveDataExtractor(username,pointhandler,upgradehandler);

        // CREATE CONTROLLER
        UpgradeController upgradecontroller = new UpgradeController(upgradehandler);
        SaveLocalController savelocalcontroller = new SaveLocalController(savedataextractor);
        SaveServerController saveservercontroller = new SaveServerController(savedataextractor);
        LoadLocalController loadlocalcontroller = new LoadLocalController(username,pointhandler,upgradehandler);
        LoadServerController loadservercontroller = new LoadServerController(username,pointhandler,upgradehandler);

        // CREATES PANELS
        mainWindow = new BorderPane();
        WordPanel wordpanel = new WordPanel();
        PointCounterPanel pointcounterpanel = new PointCounterPanel();
        UpgradePanel upgradepanel = new UpgradePanel(upgradecontroller);
        HealthPanel healthpanel = new HealthPanel();
        GUI gui = new GUI(wordpanel,upgradepanel,pointcounterpanel,healthpanel);


        // ADD OBSERVERS
        wordhandler.addObserver(wordpanel);
        pointhandler.addObserver(pointcounterpanel);
        upgradehandler.addObserver(upgradepanel);
        healthhandler.addObserver(healthpanel);

        //CREATE UPGRADES
        createUpgrades(pointhandler,upgradehandler,healthhandler);

        // CREATE MENYBAR
        Menubar menu = new Menubar(savelocalcontroller,saveservercontroller,loadlocalcontroller,loadservercontroller);
        mainWindow.setTop(menu);
        mainWindow.setCenter(gui);


        // INIT
        pointhandler.updateNotify();
        wordhandler.updateNotify();

        mainWindow.setOnKeyPressed(new KeyController(wordhandler));



    }

    /**
     * Skapar uppgraderingar samt lägger till kontroller till varje.
     * @param pointhandler skickar en referens till en pointhandler
     * @param upgrades skickar en referens till upgrades
     * @param healthhandler skickar en referens till healthhandler
     */
    private static void createUpgrades(PointHandler pointhandler, UpgradeHandler upgrades,HealthHandler healthhandler){
        PointsPerLetterUpgrade letterUpgrade = new PointsPerLetterUpgrade(pointhandler);
        PointsPerSecondUpgrade secondUpgrade = new PointsPerSecondUpgrade(pointhandler);
        HealUpgrade healupgrade = new HealUpgrade(pointhandler,healthhandler);
        upgrades.addUpgrade(letterUpgrade);
        upgrades.addUpgrade(secondUpgrade);
        upgrades.addUpgrade(healupgrade);
    }

    /**
     * Skapar två timelines som används för att kalla metoder parallellt med main programmet
     * @param pointhandler skickar referens till pointhandler
     * @param healthhandler skicakr referens till healthandler
     */
    private void startTimeLines(PointHandler pointhandler, HealthHandler healthhandler){
        pointsPerSecTimeline = new Timeline(new KeyFrame(Duration.millis(1000),ae -> pointhandler.pointsPerSecTick()));
        pointsPerSecTimeline.setCycleCount(Animation.INDEFINITE);
        pointsPerSecTimeline.play();

        damagePerSecTimeline = new Timeline(new KeyFrame(Duration.millis(500),ae -> healthhandler.takeDamage(1)));
        damagePerSecTimeline.setCycleCount(Animation.INDEFINITE);
        damagePerSecTimeline.play();
    }

    /**
     * Returnerar Singleplayers Scene
     * @return en ny Scene som är mainWindow
     */
    public Scene getScene(){
        return new Scene(mainWindow,900,600);
    }

    /**
     * Stänger av Timelines så de slutas köra parallellt och kallar på GameoverScene
     */
    public static void gameOver() {
        pointsPerSecTimeline.stop();
        damagePerSecTimeline.stop();
        Main.launchGameOverScene();
    }
}
