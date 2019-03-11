package Controllers.MenubarControllers;

import GameLogic.PointHandler;
import GameLogic.UpgradeHandler;
import THutil.FileIO.SaveFileLoader;
import THutil.Network.Client;
import THutil.SaveDataLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

import java.io.File;

public class LoadServerController implements EventHandler<ActionEvent> {
    private PointHandler pointhandler;
    private UpgradeHandler upgradehandler;
    private String username;
    private File saveFile;

    /**
     * Skapar en LoadServerController
     * @param username spelarens username
     * @param pointhandler vilken pointhandler den ska känna till
     * @param upgradehandler vilken upgradehandler den ska känna till
     */
    public LoadServerController(String username,PointHandler pointhandler,UpgradeHandler upgradehandler){
        this.username = username;
        this.pointhandler = pointhandler;
        this.upgradehandler = upgradehandler;
    }

     /**
     * Vad som ska ske när man tryck på rätt menyalternativ
     * @param event det menyalternativ man tryckt på
     */
    @Override
    public void handle(ActionEvent event) {
        try{

            saveFile = Client.loadFromServer(username);
            SaveDataLoader.loadSaveData(SaveFileLoader.LoadFromFile(username,saveFile),pointhandler,upgradehandler);
        }catch (Exception e){
            Alert connectionFailedAlert = new Alert(Alert.AlertType.ERROR);
            connectionFailedAlert.setTitle("Error");
            connectionFailedAlert.setHeaderText("Connection Error");
            connectionFailedAlert.setContentText("Couldn't connect to server");
            connectionFailedAlert.showAndWait();
        }
    }
}
