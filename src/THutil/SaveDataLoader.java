package THutil;

import GameLogic.PointHandler;
import GameLogic.UpgradeHandler;
import DataEncapsulation.SaveData;
/**
 * Laddar in spardata till handlers.
 * @author Eric Rylander
 * @version 2019-03-12
 */
public class SaveDataLoader {
    /**
     * Laddar in spardata till rätt Handler
     * @param savedata spardatan som ska laddas in
     * @param pointhandler vilken pointHandler som den ska laddas till
     * @param upgradehandler vilken upgradeHandler som den ska laddas till
     */
    public static void loadSaveData(SaveData savedata, PointHandler pointhandler, UpgradeHandler upgradehandler){
        pointhandler.loadPointData(savedata.pointdata);
        upgradehandler.loadUpgradeData(savedata.upgradeDataList);
    }
}
