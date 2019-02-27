package THutil.FileIO;

import Notifydata.PointData;
import Notifydata.SaveData;
import Notifydata.UpgradeData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class SaveFileLoader {

    public static SaveData LoadFromFile(String username,File saveFile){
        try {


            //File saveFile = new File(username+".txt");
            PointData pointdata = new PointData(0,0,0,0);
            ArrayList<UpgradeData> upgradeDataList = new ArrayList<>();
            BufferedReader fileread = new BufferedReader(new FileReader(saveFile));
            pointdata.points = Float.valueOf(fileread.readLine());
            pointdata.totalPoints = Float.valueOf(fileread.readLine());
            pointdata.pointsPerLetter = Float.valueOf(fileread.readLine());
            pointdata.pointsPerSec = Float.valueOf(fileread.readLine());
            String line = null;
            UpgradeData upgradedata = new UpgradeData(0,0,"");
            while((line = fileread.readLine()) != null){
                upgradedata.index = Integer.valueOf(line);
                upgradedata.level = Integer.valueOf(fileread.readLine());
                upgradedata.name = null;
                upgradeDataList.add(upgradedata);
            }
            fileread.close();
            return new SaveData(username,pointdata,upgradeDataList);

        } catch (Exception e) {
            System.out.println(e);
        }
       return null;
    }
}
