package THutil.FileIO;

import GameLogic.PointHandler;
import GameLogic.UpgradeHandler;
import Notifydata.SaveData;

public class SaveDataExtractor {
   private PointHandler pointhandler;
   private UpgradeHandler upgradehandler;

   public SaveDataExtractor(PointHandler pointhandler,UpgradeHandler upgradehandler){
       this.pointhandler = pointhandler;
       this.upgradehandler = upgradehandler;
   }

   public SaveData getSaveData(){
       return new SaveData(pointhandler.getPointData(),upgradehandler.getUpgradeDataList());
   }
}
