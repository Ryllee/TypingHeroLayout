package Network;


import GameLogic.SaveWriter;

import java.io.*;
import java.net.Socket;

public class Client  {

    private Socket socket;
    private File savefile;
    private String username;
    private float points;
    private float totalPoints;
    private float pointsPerLetter;
    private float pointsPerSec;


    public Client(float points, float totalPoints,float pointsPerLetter,float pointsPerSec){
        username = "Rylle";
        this.points = points;
        this.totalPoints = totalPoints;
        this.pointsPerLetter = pointsPerLetter;
        this.pointsPerSec = pointsPerSec;
        savefile = new File(username + ".txt");
        try{
            socket = new Socket("90.229.141.157", 9999);
        }catch (Exception e){
            System.out.println(e);
        }
        SaveWriter saveToLocalFile = new SaveWriter(points,totalPoints,pointsPerLetter,pointsPerSec);
        saveToLocalFile.writeToFile();
    }

    public void sendToServer(){
        try {
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
        }catch(Exception e){
            System.out.println(e);
        }

    }

    public void closeServerConnection(){
        try {
            socket.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
