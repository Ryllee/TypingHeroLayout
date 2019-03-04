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
import Upgrades.PointsPerLetterUpgrade;
import Upgrades.PointsPerSecondUpgrade;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.util.Timer;

public class SinglePlayer {

     private BorderPane mainWindow;

    public SinglePlayer(String username, Timer timer){
        WordLoader loader = new WordLoader();


        // CREATES HANDLER
        PointHandler pointhandler = new PointHandler();
        HealthHandler healthhandler = new HealthHandler(100,100);
        WordHandler wordhandler = new WordHandler(loader.loadWords(),pointhandler, healthhandler);
        UpgradeHandler upgradehandler = new UpgradeHandler();

        // CREATE TIMER
        timer.schedule(new PointsPerSecondsTask(pointhandler),0,1000);
        timer.schedule(new DamagePerSecondTask(healthhandler),0,1000);

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
        createUpgrades(pointhandler,upgradehandler);

        // CREATE MENYBAR
        Menubar menu = new Menubar(savelocalcontroller,saveservercontroller,loadlocalcontroller,loadservercontroller);
        mainWindow.setTop(menu);
        mainWindow.setCenter(gui);


        // INIT
        pointhandler.updateNotify();
        wordhandler.updateNotify();

        mainWindow.setOnKeyPressed(new KeyController(wordhandler));



    }
    private static void createUpgrades(PointHandler pointhandler, UpgradeHandler upgrades){
        PointsPerLetterUpgrade letterUpgrade = new PointsPerLetterUpgrade(pointhandler);
        PointsPerSecondUpgrade secondUpgrade = new PointsPerSecondUpgrade(pointhandler);
        upgrades.addUpgrade(letterUpgrade);
        upgrades.addUpgrade(secondUpgrade);
    }

    public Scene getScene(){
        return new Scene(mainWindow,900,600);
    }
}
