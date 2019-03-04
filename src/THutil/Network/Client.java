package THutil.Network;

import Notifydata.SaveData;
import THutil.FileIO.SaveWriter;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Client {

    public static void saveOnServer(SaveData savedata){
        File savefile = SaveWriter.writeToFile(savedata);
        try {
            Socket socket = new Socket("90.229.141.157",9999);

            DataOutputStream sendCommand = new DataOutputStream(socket.getOutputStream());
            sendCommand.writeUTF("SAVE");
            sendCommand.flush();

            DataOutputStream sendFilename = new DataOutputStream(socket.getOutputStream());
            sendFilename.writeUTF(savedata.username+".txt");
            sendFilename.flush();

            byte[] fileSize = new byte[(int) savefile.length()];
            FileInputStream fileIn = new FileInputStream(savefile);
            BufferedInputStream fileBIn = new BufferedInputStream(fileIn);
            fileBIn.read(fileSize, 0, fileSize.length);
            OutputStream output = socket.getOutputStream();
            System.out.println("Sending file(" + fileSize.length + " bytes)");
            output.write(fileSize, 0, fileSize.length);
            output.flush();
            fileBIn.close();
            fileIn.close();
            System.out.println("File sent, waiting for response from server");
            //väntar på bekräftelse från server
            DataInputStream response = new DataInputStream(socket.getInputStream());
            String serverResponse = (String) response.readUTF();
            System.out.println(serverResponse);

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static File loadFromServer(String username){
        try{
            Socket socket = new Socket("90.229.141.157",9999);
            final int FILE_SIZE = 10000;
            String url = System.getProperty("user.dir");
            File loadedFile = new File(url+"\\res\\"+username +".txt");

            DataOutputStream sendCommand = new DataOutputStream(socket.getOutputStream());
            sendCommand.writeUTF("LOAD");
            sendCommand.flush();

            DataOutputStream sendFileName = new DataOutputStream(socket.getOutputStream());
            sendFileName.writeUTF(username);
            sendFileName.flush();

            byte[] fileSize = new byte[FILE_SIZE];
            InputStream input = socket.getInputStream();
            FileOutputStream fileOut = new FileOutputStream(loadedFile);
            BufferedOutputStream fileBOut = new BufferedOutputStream(fileOut);
            int bytesread = input.read(fileSize, 0, fileSize.length);
            fileBOut.write(fileSize,0,bytesread);
            fileBOut.flush();
            System.out.println("File " + username + ".txt downloaded(" + bytesread + " bytes read)");
            fileBOut.close();
            fileOut.close();
            return loadedFile;

        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static LinkedHashMap<String,String> getHighscore(){
        try {

            Socket socket = new Socket("localhost",9999);
            DataOutputStream sendCommand = new DataOutputStream(socket.getOutputStream());
            sendCommand.writeUTF("HIGHSCORE");


            LinkedHashMap<String,String> highscoreMap = new LinkedHashMap<>();
            DataInputStream input = new DataInputStream(socket.getInputStream());
            String msg = input.readUTF();
            int listSize = Integer.valueOf(msg);
            for(int index = 0; index < listSize; index++){
                String username = input.readUTF();
                String score = input.readUTF();
                highscoreMap.put(username,score);
            }
            return highscoreMap;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
