package Controllers.MenubarControllers;

import THutil.SaveDataExtractor;
import THutil.Network.Client;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
/**
 * Controller-klass för menyalternativet Save to Server.
 * @author Eric Rylander
 * @version 2019-03-12
 */
public class SaveServerController implements EventHandler<ActionEvent> {
    SaveDataExtractor savedataextractor;

    /**
     * Skapar en SaveServerController
     * @param savedataextractor vilken savadataextractor den ska känna till
     */
    public SaveServerController(SaveDataExtractor savedataextractor){
        this.savedataextractor = savedataextractor;
    }

    /**
     * Vad som ska ske när man tryck på rätt menyalternativ
     * @param event det menyalternativ man tryckt på
     */
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
