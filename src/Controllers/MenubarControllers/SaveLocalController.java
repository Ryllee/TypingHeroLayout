package Controllers.MenubarControllers;

import THutil.SaveDataExtractor;
import THutil.FileIO.SaveWriter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
/**
 * Controller-klass för menyalternativet Save to File.
 * @author Joel Petersson
 * @version 2019-03-12
 */
public class SaveLocalController implements EventHandler<ActionEvent> {
    SaveDataExtractor savedataextractor;


    /**
     * Skapar en SaveLocalController
     * @param savedataextractor vilken savadataextractor den ska känna till
     */
    public SaveLocalController(SaveDataExtractor savedataextractor){
        this.savedataextractor = savedataextractor;
    }

    /**
     * Vad som ska ske när man tryck på rätt menyalternativ
     * @param event det menyalternativ man tryckt på
     */
    @Override
    public void handle(ActionEvent event) {
        System.out.println("Save Local pressed");
        SaveWriter.writeToFile(savedataextractor.getSaveData());
    }
}
