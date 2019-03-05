package THutil.FileIO;

import DataEncapsulation.SaveData;
import DataEncapsulation.UpgradeData;

import java.io.File;
import java.io.FileWriter;

public class SaveWriter {

    public static File writeToFile(SaveData savedata){
        String url = System.getProperty("user.dir");
        File saveFile = new File(url+"/res/"+savedata.username +".txt");
        try{
            FileWriter filewriter = new FileWriter(saveFile);
            filewriter.write(savedata.pointdata.points + "\n");
            filewriter.write(savedata.pointdata.totalPoints + "\n");
            filewriter.write(savedata.pointdata.pointsPerLetter + "\n");
            filewriter.write(savedata.pointdata.pointsPerSec + "\n");
            for(UpgradeData ud : savedata.upgradeDataList){
                filewriter.write(ud.index +"\n");
                filewriter.write(ud.level +"\n");
            }
            filewriter.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return saveFile;
    }
}
