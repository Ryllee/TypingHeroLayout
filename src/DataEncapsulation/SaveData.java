package DataEncapsulation;


import java.util.ArrayList;
/**
 * Inkappslings-klass som samlar relevant data för att ladda och spara.
 * @author Eric Rylander
 * @version 2019-03-12
 */
public class SaveData {
    public String username;
    public PointData pointdata;
    public ArrayList<UpgradeData> upgradeDataList;

    /**
     * Skapar en SavaData
     * @param username spelarens username
     * @param pointdata en PointData innehållande spelarens poäng
     * @param upgradeDataList en lista innehållande alla spelarens uppgraderingar
     */
    public SaveData(String username,PointData pointdata, ArrayList<UpgradeData> upgradeDataList){
        this.username = username;
        this.pointdata = pointdata;
        this.upgradeDataList = upgradeDataList;
    }
}
