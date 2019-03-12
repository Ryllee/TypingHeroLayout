package THutil.FileIO;

import java.io.*;
import java.util.ArrayList;
/**
 * Laddar in ord från en fil och skapar en lista.
 * @author Arvid Holmqvist
 * @version 2019-03-12
 */
public class WordLoader {
    File wordFile;
    BufferedReader fileread;

    /**
     * Konstruktor för wordloader
     */
    public WordLoader(){
        String url = System.getProperty("user.dir");
        wordFile = new File(url+"/res/1-1000.txt");
        try {
            fileread = new BufferedReader(new FileReader(wordFile));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    /**
     * Läser in ord från en fil
     * @return Arraylist av ord som läst in
     */
    public ArrayList<String> loadWords(){
        String line = null;
        ArrayList<String> result = new ArrayList<String>();
        try{
            while((line=fileread.readLine()) != null){
                result.add(line);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
}
