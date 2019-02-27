package Graphics;

import Controllers.MenubarControllers.LoadLocalController;
import Controllers.MenubarControllers.LoadServerController;
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
    private MenuItem loadFromServer;

    public Menubar(SaveLocalController saveLocal, SaveServerController saveServer, LoadLocalController loadLocal,LoadServerController loadServer){
        filemenu = new Menu("File");
        saveToFile = new MenuItem("Save to file");
        saveToServer = new MenuItem("Save to server");
        loadFromFile = new MenuItem("Load from file");
        loadFromServer = new MenuItem("Load from server");

        filemenu.getItems().add(saveToFile);
        filemenu.getItems().add(saveToServer);
        filemenu.getItems().add(loadFromFile);
        filemenu.getItems().add(loadFromServer);
        addMenubarControllers(saveLocal,saveServer,loadLocal,loadServer);
        getMenus().add(filemenu);
    }

    private void addMenubarControllers(SaveLocalController saveLocal, SaveServerController saveServer, LoadLocalController loadLocal, LoadServerController loadServer){
        saveToFile.setOnAction(saveLocal);
        saveToServer.setOnAction(saveServer);
        loadFromFile.setOnAction(loadLocal);
        loadFromServer.setOnAction(loadServer);
    }
}
