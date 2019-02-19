import Controllers.KeyController;
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
        // CREATES HANDLER
        PointHandler points = new PointHandler();
        WordHandler words = new WordHandler(new ArrayList<String>(),points);
        UpgradeHandler upgrades = new UpgradeHandler(points);

        BorderPane mainWindow = new BorderPane();

        // CREATES PANELS
        WordPanel wordpanel = new WordPanel();
        PointCounterPanel pointcounterpanel = new PointCounterPanel();
        UpgradePanel upgradepanel = new UpgradePanel();

        // ADD OBSERVERS
        words.addObserver(wordpanel);
        points.addObserver(pointcounterpanel);
        upgrades.addObserver(upgradepanel);

        //CREATE UPGRADES
        createUpgrades(points,upgrades);

        GUI gui = new GUI(wordpanel,upgradepanel,pointcounterpanel);

        Menubar menu = new Menubar();
        mainWindow.setTop(menu);
        mainWindow.setCenter(gui);

        primaryStage.setScene(new Scene(mainWindow,600,600));

        // INIT
        points.updatenotify();

        //ADD EVENTHANDLERS
        primaryStage.getScene().setOnKeyPressed(new KeyController(words));
        primaryStage.show();
    }

    public static void createUpgrades(PointHandler points, UpgradeHandler upgrades){
        PointsPerLetterUpgrade letterUpgrade = new PointsPerLetterUpgrade(points, "PointsPerLetterUpgrade", "Increase your PointsPerLetter by one", 10,0,10);
        upgrades.addUpgrade(letterUpgrade);
    }
}
