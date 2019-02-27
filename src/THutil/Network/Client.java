package THutil.Network;

import Notifydata.SaveData;
import THutil.FileIO.SaveWriter;

import java.io.*;
import java.net.Socket;

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

        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
}
