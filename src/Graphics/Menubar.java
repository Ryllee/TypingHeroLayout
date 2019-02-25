package Graphics;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class Menubar extends MenuBar {

    public Menubar(){
        Menu file = new Menu("File");
        MenuItem saveToFile = new MenuItem("Save to file");
        MenuItem saveToServer = new MenuItem("Save to server");
        file.getItems().add(saveToFile);
        file.getItems().add(saveToServer);
        getMenus().add(file);
    }
}
