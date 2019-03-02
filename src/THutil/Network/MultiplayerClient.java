package THutil.Network;

import GameLogic.HealthHandler;
import Notifydata.WordData;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class MultiplayerClient implements Observer {
    private Socket socket;
    private DataOutputStream out;
    public MultiplayerClient(Socket socket, HealthHandler healthhandler, String gameid) {
        this.socket = socket;

        System.out.println("Successfully connected!");
        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("JOIN");
            out.writeUTF(gameid);
        } catch (Exception e) {
            System.out.println(e);
        }
        ClientListener listener = new ClientListener(socket, healthhandler);


        listener.start();

        out = null;

        try {
            out = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void send(String msg) {
        try {
            out.writeUTF(msg);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof WordData) {
            if (((WordData) arg).command == 3) {
                send("ATK");
            }
        }
    }
}
