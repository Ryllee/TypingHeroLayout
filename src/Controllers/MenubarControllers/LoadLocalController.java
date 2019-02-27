package Controllers.MenubarControllers;

import GameLogic.PointHandler;
import GameLogic.UpgradeHandler;
import Notifydata.PointData;
import Notifydata.SaveData;
import Notifydata.UpgradeData;
import THutil.SaveDataLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class LoadLocalController implements EventHandler<ActionEvent> {
    private PointHandler pointhandler;
    private UpgradeHandler upgradehandler;

    public LoadLocalController(PointHandler pointhandler,UpgradeHandler upgradehandler){

        this.pointhandler = pointhandler;
        this.upgradehandler = upgradehandler;
    }

    @Override
    public void handle(ActionEvent event) {
        ArrayList<UpgradeData> upgradedataListtest = new ArrayList<UpgradeData>();
        upgradedataListtest.add(new UpgradeData(0,1,"hej"));
        upgradedataListtest.add(new UpgradeData(1,2,"hej"));
        SaveData testsave = new SaveData("TEST",new PointData(10,10,2,1),upgradedataListtest);
        SaveDataLoader.loadSaveData(testsave,pointhandler,upgradehandler);
    }
}
