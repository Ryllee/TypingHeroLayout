import Controllers.KeyController;
import GameLogic.MenubarHandler;
import GameLogic.PointHandler;
import GameLogic.UpgradeHandler;
import GameLogic.WordHandler;
import Graphics.*;

import Upgrades.PointsPerLetterUpgrade;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {


    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        WordLoader loader = new WordLoader();


        // CREATES HANDLER
        PointHandler pointhandler = new PointHandler();
        WordHandler wordhandler = new WordHandler(loader.loadWords(),pointhandler);
        UpgradeHandler upgradehandler = new UpgradeHandler();
        MenubarHandler menubarhandler = new MenubarHandler(pointhandler);

        // CREATES PANELS
        BorderPane mainWindow = new BorderPane();
        WordPanel wordpanel = new WordPanel();
        PointCounterPanel pointcounterpanel = new PointCounterPanel();
        UpgradePanel upgradepanel = new UpgradePanel();

        // CREATE MENYBAR
        Menubar menu = new Menubar();

        // ADD OBSERVERS
        wordhandler.addObserver(wordpanel);
        pointhandler.addObserver(pointcounterpanel);
        upgradehandler.addObserver(upgradepanel);
        menubarhandler.addObserver(menu);

        //CREATE UPGRADES
        createUpgrades(pointhandler,upgradehandler);

        // CREATE GUI
        GUI gui = new GUI(wordpanel,upgradepanel,pointcounterpanel);


        // CREATE SCENE
        mainWindow.setTop(menu);
        mainWindow.setCenter(gui);
        primaryStage.setScene(new Scene(mainWindow,600,600));

        // INIT
        pointhandler.updateNotify();
        wordhandler.updateNotify();
        menubarhandler.updateNotify();

        //ADD EVENTHANDLERS
        primaryStage.getScene().setOnKeyPressed(new KeyController(wordhandler));

        // SHOW SCENE
        primaryStage.show();
    }

    private static void createUpgrades(PointHandler points, UpgradeHandler upgrades){
        PointsPerLetterUpgrade letterUpgrade = new PointsPerLetterUpgrade(points, "PointsPerLetterUpgrade", "Increase your PointsPerLetter by one", 10,0,10);
        upgrades.addUpgrade(letterUpgrade);
    }

    private static void createUpgrades(PointHandler points, UpgradeHandler upgrades, float cost, int currentLevel){
        PointsPerLetterUpgrade letterUpgrade = new PointsPerLetterUpgrade(points, "PointsPerLetterUpgrade", "Increase your PointsPerLetter by one", cost,currentLevel,10);
        upgrades.addUpgrade(letterUpgrade);
    }
}
