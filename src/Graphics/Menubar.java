package Graphics;

import Controllers.MenubarControllers.LoadLocalController;
import Controllers.MenubarControllers.SaveLocalController;
import Controllers.MenubarControllers.SaveServerController;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class Menubar extends MenuBar {
    private Menu filemenu;
    private MenuItem saveToFile;
    private MenuItem saveToServer;
    private MenuItem loadFromFile;

    public Menubar(SaveLocalController saveLocal, SaveServerController saveServer, LoadLocalController loadLocal){
        filemenu = new Menu("File");
        saveToFile = new MenuItem("Save to file");
        saveToServer = new MenuItem("Save to server");
        loadFromFile = new MenuItem("Load from file");

        filemenu.getItems().add(saveToFile);
        filemenu.getItems().add(saveToServer);
        filemenu.getItems().add(loadFromFile);
        addMenubarControllers(saveLocal,saveServer,loadLocal);
        getMenus().add(filemenu);
    }

    private void addMenubarControllers(SaveLocalController saveLocal, SaveServerController saveServer, LoadLocalController loadLocal){
        saveToFile.setOnAction(saveLocal);
        saveToServer.setOnAction(saveServer);
        loadFromFile.setOnAction(loadLocal);
    }
}
