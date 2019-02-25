import Controllers.KeyController;
import Controllers.MenubarControllers.SaveLocalController;
import Controllers.MenubarControllers.SaveServerController;
import Controllers.UpgradeController;
import GameLogic.PointHandler;
import GameLogic.PointsPerSecondsTask;
import GameLogic.UpgradeHandler;
import GameLogic.WordHandler;
import Graphics.*;

import THutil.FileIO.SaveDataExtractor;
import THutil.WordLoader;
import Upgrades.PointsPerLetterUpgrade;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Timer;

public class Main extends Application {

    private Timer timer;

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

        // CREATE TIMER
        timer = new Timer();
        timer.schedule(new PointsPerSecondsTask(pointhandler),0,1000);

        // CREATE DATAEXTRACTOR

        SaveDataExtractor savedataextractor = new SaveDataExtractor(pointhandler,upgradehandler);

        // CREATE CONTROLLER
        UpgradeController upgradecontroller = new UpgradeController(upgradehandler);
        SaveLocalController savelocalcontroller = new SaveLocalController(savedataextractor);
        SaveServerController saveservercontroller = new SaveServerController(savedataextractor);

        // CREATES PANELS
        BorderPane mainWindow = new BorderPane();
        WordPanel wordpanel = new WordPanel();
        PointCounterPanel pointcounterpanel = new PointCounterPanel();
        UpgradePanel upgradepanel = new UpgradePanel(upgradecontroller);
        GUI gui = new GUI(wordpanel,upgradepanel,pointcounterpanel);

        // ADD OBSERVERS
        wordhandler.addObserver(wordpanel);
        pointhandler.addObserver(pointcounterpanel);
        upgradehandler.addObserver(upgradepanel);

        //CREATE UPGRADES
        createUpgrades(pointhandler,upgradehandler);

        // CREATE MENYBAR
        Menubar menu = new Menubar(savelocalcontroller,saveservercontroller);
        mainWindow.setTop(menu);
        mainWindow.setCenter(gui);

        // CREATE SCENE
        primaryStage.setScene(new Scene(mainWindow,900,600));

        // INIT
        pointhandler.updateNotify();
        wordhandler.updateNotify();

        //ADD EVENTHANDLERS
        primaryStage.getScene().setOnKeyPressed(new KeyController(wordhandler));

        // SHOW SCENE
        primaryStage.show();
    }

    private static void createUpgrades(PointHandler pointhandler, UpgradeHandler upgrades){
        PointsPerLetterUpgrade letterUpgrade = new PointsPerLetterUpgrade(pointhandler);
        upgrades.addUpgrade(letterUpgrade);
    }

    @Override
    public void stop() throws Exception {
        timer.cancel();
        super.stop();
    }
}
