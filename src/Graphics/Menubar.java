package Graphics;

import Controllers.MenubarController;
import GameLogic.MenubarHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import java.util.Observable;
import java.util.Observer;

public class Menubar extends MenuBar implements Observer {
    Menu filemenu;
    MenuItem savemenu;
    public Menubar(){
         filemenu = new Menu("File");
         savemenu = new MenuItem("Save");

        filemenu.getItems().add(savemenu);
        getMenus().add(filemenu);
    }

    @Override
    public void update(Observable o, Object arg) {
        if( arg instanceof MenubarHandler)
        savemenu.setOnAction(new MenubarController(((MenubarHandler) arg)));
    }
}
