package DataEncapsulation;


import java.util.ArrayList;

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
