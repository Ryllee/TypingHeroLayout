package Controllers;

import GameLogic.MenubarHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SaveToLocalFileController implements EventHandler<ActionEvent> {
    MenubarHandler menubarhandler;
    public SaveToLocalFileController(MenubarHandler menubarhandler){
        this.menubarhandler = menubarhandler;
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("saveLocalPressed");
        menubarhandler.saveToLocalFile();
    }
}
