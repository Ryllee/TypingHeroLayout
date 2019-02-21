package GameLogic;

import java.util.Observable;

public class MenubarHandler extends Observable {

    private PointHandler pointhandler;


    public MenubarHandler(PointHandler pointhandler){
        this.pointhandler = pointhandler;
    }

    public void saveToFile(){
       SaveWriter save = new SaveWriter(pointhandler.getPoints(),pointhandler.getTotalPoints(),pointhandler.getPointsPerLetter(),pointhandler.getPointsPerSec());
       save.writeToFile();
    }

    public void updateNotify(){
        setChanged();
        notifyObservers(this);
    }
}
