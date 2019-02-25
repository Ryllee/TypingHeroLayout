package THutil;

import Notifydata.SaveData;
import Notifydata.UpgradeData;

import java.io.File;
import java.io.FileWriter;

public class SaveWriter {

    public static void writeToFile(SaveData savedata){
        File saveFile = new File("Test.txt");
        try{
            FileWriter filewriter = new FileWriter(saveFile);
            filewriter.write(savedata.pointdata.points + "\n");
            filewriter.write(savedata.pointdata.totalPoints + "\n");
            filewriter.write(savedata.pointdata.pointsPerLetter + "\n");
            filewriter.write(savedata.pointdata.pointsPerSec + "\n");
            for(UpgradeData ud : savedata.upgradedataList){
                filewriter.write(ud.index +"\n");
                filewriter.write(ud.level +"\n");
            }
            filewriter.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
