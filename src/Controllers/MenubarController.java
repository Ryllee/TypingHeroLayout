package Controllers;

import GameLogic.MenubarHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MenubarController implements EventHandler<ActionEvent> {
    MenubarHandler menubarhandler;

    public MenubarController(MenubarHandler menubarhandler){
        this.menubarhandler = menubarhandler;
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("savePressed");
        menubarhandler.saveToFile();
    }
}
