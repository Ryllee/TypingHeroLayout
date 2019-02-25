package Notifydata;


import java.util.ArrayList;

public class SaveData {
    public PointData pointdata;
    public ArrayList<UpgradeData> upgradedataList;

    public SaveData(PointData pointdata, ArrayList<UpgradeData> upgradedataList){
        this.pointdata = pointdata;
        this.upgradedataList = upgradedataList;
    }
}
