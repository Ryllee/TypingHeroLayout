package GameLogic;


import java.util.TimerTask;

public class PointsPerSecondsTask extends TimerTask {

    private PointHandler pointhandler;

    public PointsPerSecondsTask(PointHandler pointhandler){
        this.pointhandler = pointhandler;
    }
    @Override
    public void run() {
       pointhandler.pointsPerSecTick();
    }
}
