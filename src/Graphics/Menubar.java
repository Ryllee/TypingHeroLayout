package Graphics;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class Menubar extends MenuBar {

    public Menubar(){
        Menu file = new Menu("File");
        MenuItem save = new MenuItem("Save");
        file.getItems().add(save);
        getMenus().add(file);
    }
}
