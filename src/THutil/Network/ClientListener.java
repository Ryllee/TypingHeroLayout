package THutil.Network;
import GameLogic.HealthHandler;

import java.io.DataInputStream;
import java.net.Socket;

public class ClientListener extends Thread{
    private HealthHandler healthhandler;
    private DataInputStream in;
    public ClientListener(Socket socket, HealthHandler healthhandler) {
        try {
            this.in = new DataInputStream(socket.getInputStream());
        } catch (Exception e) {
            System.out.println(e);
        }

        this.healthhandler = healthhandler;
        setDaemon(true);
    }
    @Override
    public void run() {
        String response = null;
        while(true) {
            try {
                response = in.readUTF();
                System.out.println(response);
                healthhandler.takeDamage(3);
            } catch (Exception e) {
                System.out.println(e);
                return;
            }
        }
    }
}
