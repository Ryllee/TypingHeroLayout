package Controllers;


import GameLogic.MenubarHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SaveToServerFileController implements EventHandler<ActionEvent> {
    MenubarHandler menubarhandler;

    public SaveToServerFileController(MenubarHandler menubarhandler){
        this.menubarhandler = menubarhandler;
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("saveServerPressed");
        menubarhandler.saveToServerFile();
    }
}
