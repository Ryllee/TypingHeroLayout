package Graphics;

import Controllers.SaveToLocalFileController;
import Controllers.SaveToServerFileController;
import GameLogic.MenubarHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import java.util.Observable;
import java.util.Observer;

public class Menubar extends MenuBar implements Observer {
    Menu filemenu;
    MenuItem saveToLocalFilemenu;
    MenuItem saveToServerFilemenu;
    public Menubar(){
         filemenu = new Menu("File");
         saveToLocalFilemenu = new MenuItem("Save on Local");
         saveToServerFilemenu = new MenuItem("Save on Server");

        filemenu.getItems().add(saveToLocalFilemenu);
        filemenu.getItems().add(saveToServerFilemenu);
        getMenus().add(filemenu);
    }

    @Override
    public void update(Observable o, Object arg) {
        if( arg instanceof MenubarHandler)
        saveToLocalFilemenu.setOnAction(new SaveToLocalFileController(((MenubarHandler) arg)));
        saveToServerFilemenu.setOnAction(new SaveToServerFileController(((MenubarHandler) arg)));
    }
}
