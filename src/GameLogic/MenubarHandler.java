package GameLogic;

import Network.Client;

import java.util.Observable;

public class MenubarHandler extends Observable {

    private PointHandler pointhandler;


    public MenubarHandler(PointHandler pointhandler){
        this.pointhandler = pointhandler;
    }

    public void saveToLocalFile(){
       SaveWriter saveToLocal = new SaveWriter(pointhandler.getPoints(),pointhandler.getTotalPoints(),pointhandler.getPointsPerLetter(),pointhandler.getPointsPerSec());
       saveToLocal.writeToFile();
    }

    public void saveToServerFile(){
        Client saveToServer = new Client(pointhandler.getPoints(),pointhandler.getTotalPoints(),pointhandler.getPointsPerLetter(),pointhandler.getPointsPerSec());
        saveToServer.sendToServer();
        saveToServer.closeServerConnection();
    }

    public void updateNotify(){
        setChanged();
        notifyObservers(this);
    }
}
