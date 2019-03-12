package THutil;

import GameLogic.PointHandler;
import GameLogic.UpgradeHandler;
import DataEncapsulation.SaveData;
/**
 * Extraherar och kombinerar data från Handlers.
 * @author Eric Rylander
 * @version 2019-03-12
 */
public class SaveDataExtractor {
   private PointHandler pointhandler;
   private UpgradeHandler upgradehandler;
   private String username;

    /**
     * Konstruktor för SaveDataExtractor, skapar ref till rätt Handlers
     * @param username vilket username spelaren har
     * @param pointhandler vilken pointHandler man ska hämta ifrån
     * @param upgradehandler vilken upgradeHandler man ska hämta ifrån
     */
   public SaveDataExtractor(String username,PointHandler pointhandler,UpgradeHandler upgradehandler){
       this.username = username;
       this.pointhandler = pointhandler;
       this.upgradehandler = upgradehandler;
   }

    /**
     * Hämta spardata från Handlers och spara den i en SaveData
     * @return en SaveData med spardatan från Handlers
     */
   public SaveData getSaveData(){
       return new SaveData(username,pointhandler.getPointData(),upgradehandler.getUpgradeDataList());
   }
}
