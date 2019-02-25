package Controllers.MenubarControllers;

import THutil.FileIO.SaveDataExtractor;
import THutil.FileIO.SaveWriter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SaveLocalController implements EventHandler<ActionEvent> {
    SaveDataExtractor savedataextractor;

    public SaveLocalController(SaveDataExtractor savedataextractor){
        this.savedataextractor = savedataextractor;
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("Save Local pressed");
        SaveWriter.writeToFile(savedataextractor.getSaveData());
    }
}
