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
import THutil.FileIO.SaveDataExtractor;
import THutil.WordLoader;
import Upgrades.PointsPerLetterUpgrade;
import Upgrades.PointsPerSecondUpgrade;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.util.Timer;

public class SinglePlayer {

     private BorderPane mainWindow;
     private Main main;

    public SinglePlayer(String username, Timer timer, Main main){
        this.main = main;
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
        timer.schedule(new PointsPerSecondsTask(pointhandler),0,1000);

        // CREATE DATAEXTRACTOR

        SaveDataExtractor savedataextractor = new SaveDataExtractor(pointhandler,upgradehandler);

        // CREATE CONTROLLER
        UpgradeController upgradecontroller = new UpgradeController(upgradehandler);
        SaveLocalController savelocalcontroller = new SaveLocalController(savedataextractor);
        SaveServerController saveservercontroller = new SaveServerController(savedataextractor);
        LoadLocalController loadlocalcontroller = new LoadLocalController(pointhandler,upgradehandler);

        // CREATES PANELS
        mainWindow = new BorderPane();
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
