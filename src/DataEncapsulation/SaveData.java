package DataEncapsulation;


import java.util.ArrayList;

public class SaveData {
    public String username;
    public PointData pointdata;
    public ArrayList<UpgradeData> upgradeDataList;

    public SaveData(String username,PointData pointdata, ArrayList<UpgradeData> upgradeDataList){
        this.username = username;
        this.pointdata = pointdata;
        this.upgradeDataList = upgradeDataList;
    }
}
