package Controllers.MenubarControllers;

import GameLogic.PointHandler;
import GameLogic.UpgradeHandler;
import Notifydata.PointData;
import Notifydata.SaveData;
import Notifydata.UpgradeData;
import THutil.FileIO.SaveFileLoader;
import THutil.Network.Client;
import THutil.SaveDataLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LoadLocalController implements EventHandler<ActionEvent> {
    private PointHandler pointhandler;
    private UpgradeHandler upgradehandler;
    private String username;
    private File saveFile;

    public LoadLocalController(String username,PointHandler pointhandler,UpgradeHandler upgradehandler){
        this.username = username;
        this.pointhandler = pointhandler;
        this.upgradehandler = upgradehandler;
    }

    @Override
    public void handle(ActionEvent event) {
        try{
            String url = System.getProperty("user.dir");
            saveFile = new File(url+"/res/"+username+".txt");
            SaveDataLoader.loadSaveData(SaveFileLoader.LoadFromFile(username,saveFile),pointhandler,upgradehandler);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
