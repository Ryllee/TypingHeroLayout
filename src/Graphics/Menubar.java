package Graphics;

import Controllers.MenubarControllers.SaveLocalController;
import Controllers.MenubarControllers.SaveServerController;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class Menubar extends MenuBar {
    private Menu filemenu;
    private MenuItem saveToFile;
    private MenuItem saveToServer;

    public Menubar(SaveLocalController saveLocal, SaveServerController saveServer){
        filemenu = new Menu("File");
        saveToFile = new MenuItem("Save to file");
        saveToServer = new MenuItem("Save to server");
        filemenu.getItems().add(saveToFile);
        filemenu.getItems().add(saveToServer);
        addMenubarControllers(saveLocal,saveServer);
        getMenus().add(filemenu);
    }

    private void addMenubarControllers(SaveLocalController saveLocal, SaveServerController saveServer){
        saveToFile.setOnAction(saveLocal);
        saveToServer.setOnAction(saveServer);
    }
}
