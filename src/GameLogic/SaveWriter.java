package GameLogic;

import java.io.File;
import java.io.FileWriter;


public class SaveWriter {

    private File savefile;
    private FileWriter filewriter;
    private String username;
    private float points;
    private float totalPoints;
    private float pointsPerLetter;
    private float pointsPerSec;


    public SaveWriter(float points, float totalPoints,float pointsPerLetter,float pointsPerSec){

        username = "Rylle";
        this.points = points;
        this.totalPoints = totalPoints;
        this.pointsPerLetter = pointsPerLetter;
        this.pointsPerSec = pointsPerSec;
        savefile = new File(username + ".txt");
        try{
           filewriter = new FileWriter(savefile);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void writeToFile()
    {
        try {
            filewriter.write(username + "\n");
            filewriter.write(points+"\n");
            filewriter.write(totalPoints+"\n");
            filewriter.write(pointsPerLetter+"\n");
            filewriter.write(pointsPerSec+"\n");
            filewriter.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
