package THutil;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class WordLoader {
    File wordFile;
    BufferedReader fileread;

    public WordLoader(){
        String url = System.getProperty("user.dir");
        wordFile = new File(url+"/res/1-1000.txt");
        try {
            fileread = new BufferedReader(new FileReader(wordFile));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

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
