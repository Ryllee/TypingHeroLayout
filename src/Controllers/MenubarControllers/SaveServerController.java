package Controllers.MenubarControllers;

import THutil.SaveDataExtractor;
import THutil.Network.Client;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class SaveServerController implements EventHandler<ActionEvent> {
    SaveDataExtractor savedataextractor;

    public SaveServerController(SaveDataExtractor savedataextractor){
        this.savedataextractor = savedataextractor;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            Client.saveOnServer(savedataextractor.getSaveData());
        } catch (Exception e){
            Alert connectionFailedAlert = new Alert(Alert.AlertType.ERROR);
            connectionFailedAlert.setTitle("Error");
            connectionFailedAlert.setHeaderText("Connection Error");
            connectionFailedAlert.setContentText("Couldn't connect to server.\nSaved locally.");
            connectionFailedAlert.showAndWait();
        }
    }
}
