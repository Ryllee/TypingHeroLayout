package THutil.FileIO;

import DataEncapsulation.PointData;
import DataEncapsulation.SaveData;
import DataEncapsulation.UpgradeData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
/**
 * Läser in en fil till rätt format.
 * @author Elma Esati
 * @version 2019-03-12
 */
public class SaveFileLoader {
    /**
     * Konstruktor för SaveFileLoader
     * @param username vilket username spelaren använder
     * @param saveFile vilken sparfile som ska läsas in
     * @return en SaveData innehållande informationen från sparfilen
     */
    public static SaveData LoadFromFile(String username,File saveFile){
        try {

            PointData pointdata = new PointData(0,0,0,0);
            ArrayList<UpgradeData> upgradeDataList = new ArrayList<>();
            BufferedReader fileread = new BufferedReader(new FileReader(saveFile));
            pointdata.points = Float.valueOf(fileread.readLine());
            pointdata.totalPoints = Float.valueOf(fileread.readLine());
            pointdata.pointsPerLetter = Float.valueOf(fileread.readLine());
            pointdata.pointsPerSec = Float.valueOf(fileread.readLine());
            String line = null;
            while((line = fileread.readLine()) != null){
                UpgradeData upgradedata = new UpgradeData(0,0,"");
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
