package Controllers.MenubarControllers;

import GameLogic.PointHandler;
import GameLogic.UpgradeHandler;
import THutil.FileIO.SaveFileLoader;
import THutil.SaveDataLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.File;

public class LoadLocalController implements EventHandler<ActionEvent> {
    private PointHandler pointhandler;
    private UpgradeHandler upgradehandler;
    private String username;
    private File saveFile;

    /**
     * Skapar en LoadLocalController
     * @param username spelarens username
     * @param pointhandler vilken pointhandler den ska känna till
     * @param upgradehandler vilken upgradehandler den ska känna till
     */
    public LoadLocalController(String username,PointHandler pointhandler,UpgradeHandler upgradehandler){
        this.username = username;
        this.pointhandler = pointhandler;
        this.upgradehandler = upgradehandler;
    }

    /**
     * Vad som ska ske när man tryck på rätt menyalternativ
     * @param event det menyalternativ man tryckt på
     */
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
