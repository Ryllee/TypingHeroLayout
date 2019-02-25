import Controllers.KeyController;
import Controllers.MenubarControllers.LoadLocalController;
import Controllers.MenubarControllers.SaveLocalController;
import Controllers.MenubarControllers.SaveServerController;
import Controllers.UpgradeController;
import GameLogic.PointHandler;
import GameLogic.PointsPerSecondsTask;
import GameLogic.UpgradeHandler;
import GameLogic.WordHandler;
import Graphics.*;

import Notifydata.PointData;
import Notifydata.SaveData;
import Notifydata.UpgradeData;
import THutil.FileIO.SaveDataExtractor;
import THutil.SaveDataLoader;
import THutil.WordLoader;
import Upgrades.PointsPerLetterUpgrade;
import Upgrades.PointsPerSecondUpgrade;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
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

       /* TEST FÖR LADDA SAVES
        ArrayList<UpgradeData> upgradedataListtest = new ArrayList<UpgradeData>();
        upgradedataListtest.add(new UpgradeData(0,1,"hej"));
        upgradedataListtest.add(new UpgradeData(1,2,"hej"));
        SaveData testsave = new SaveData(new PointData(10,10,2,1),upgradedataListtest);*/

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
        LoadLocalController loadlocalcontroller = new LoadLocalController(pointhandler,upgradehandler);

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
        Menubar menu = new Menubar(savelocalcontroller,saveservercontroller,loadlocalcontroller);
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
        PointsPerSecondUpgrade secondUpgrade = new PointsPerSecondUpgrade(pointhandler);
        upgrades.addUpgrade(letterUpgrade);
        upgrades.addUpgrade(secondUpgrade);
    }

    @Override
    public void stop() throws Exception {
        timer.cancel();
        super.stop();
    }
}
