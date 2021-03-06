package THutil;

import GameLogic.PointHandler;
import GameLogic.UpgradeHandler;
import DataEncapsulation.SaveData;

public class SaveDataLoader {

    public static void loadSaveData(SaveData savedata, PointHandler pointhandler, UpgradeHandler upgradehandler){
        pointhandler.loadPointData(savedata.pointdata);
        upgradehandler.loadUpgradeData(savedata.upgradeDataList);
    }
}
