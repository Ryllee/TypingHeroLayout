import Controllers.KeyController;
import GameLogic.HealthHandler;
import GameLogic.PointHandler;
import GameLogic.UpgradeHandler;
import GameLogic.WordHandler;
import Graphics.*;
import THutil.Network.MultiplayerClient;
import THutil.WordLoader;
import Upgrades.PointsPerLetterUpgrade;
import Upgrades.PointsPerSecondUpgrade;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.net.Socket;

public class MultiPlayer {
    private BorderPane mainWindow;
    private Main main;

    public MultiPlayer(String gameid, Main main) {
        this.main = main;
        WordLoader loader = new WordLoader();

        // CREATES HANDLER
        PointHandler pointhandler = new PointHandler();
        HealthHandler healthhandler = new HealthHandler(100,100);
        WordHandler wordhandler = new WordHandler(loader.loadWords(),pointhandler, healthhandler);


        mainWindow = new BorderPane();
        WordPanel wordpanel = new WordPanel();


        MultiplayerGUI m_gui = new MultiplayerGUI(wordpanel);
        // ADD OBSERVERS
        wordhandler.addObserver(wordpanel);



        mainWindow.setCenter(m_gui);


        // INIT
        try {
            MultiplayerClient client = new MultiplayerClient(new Socket("90.229.141.157", 9999), healthhandler, gameid);
            wordhandler.addObserver(client);
        } catch (Exception e) {
            System.out.println(e);
        }

        pointhandler.updateNotify();
        wordhandler.updateNotify();
        m_gui.setFocusTraversable(true);
        mainWindow.setOnKeyPressed(new KeyController(wordhandler));



    }
    private static void createUpgrades(PointHandler pointhandler, UpgradeHandler upgrades){
        PointsPerLetterUpgrade letterUpgrade = new PointsPerLetterUpgrade(pointhandler);
        PointsPerSecondUpgrade secondUpgrade = new PointsPerSecondUpgrade(pointhandler);
        upgrades.addUpgrade(letterUpgrade);
        upgrades.addUpgrade(secondUpgrade);
    }

    public Scene getScene(){
        Scene scene = new Scene(mainWindow,900,600);

        return scene;
    }
}
