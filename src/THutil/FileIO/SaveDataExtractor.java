package THutil.FileIO;

import GameLogic.PointHandler;
import GameLogic.UpgradeHandler;
import Notifydata.SaveData;

public class SaveDataExtractor {
   private PointHandler pointhandler;
   private UpgradeHandler upgradehandler;
   private String username;

   public SaveDataExtractor(String username,PointHandler pointhandler,UpgradeHandler upgradehandler){
       this.username = username;
       this.pointhandler = pointhandler;
       this.upgradehandler = upgradehandler;
   }

   public SaveData getSaveData(){
       return new SaveData(username,pointhandler.getPointData(),upgradehandler.getUpgradeDataList());
   }
}
