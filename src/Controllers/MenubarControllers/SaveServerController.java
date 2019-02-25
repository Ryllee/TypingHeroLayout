package Controllers.MenubarControllers;

import THutil.FileIO.SaveDataExtractor;
import THutil.Network.Client;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SaveServerController implements EventHandler<ActionEvent> {
    SaveDataExtractor savedataextractor;

    public SaveServerController(SaveDataExtractor savedataextractor){
        this.savedataextractor = savedataextractor;
    }

    @Override
    public void handle(ActionEvent event) {
        Client.saveOnServer(savedataextractor.getSaveData());
        System.out.println("Save Server pressed");
    }
}
