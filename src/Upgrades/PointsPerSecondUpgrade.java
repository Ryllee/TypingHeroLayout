package Upgrades;

import GameLogic.PointHandler;
import GameLogic.Upgrade;

public class PointsPerSecondUpgrade extends Upgrade {

    public PointsPerSecondUpgrade(PointHandler pointhandler){
        super(pointhandler, "Increase points per second", "Increase your PointsPerLetter by one",
                20,0,20, 1.5f);
    }

    @Override
    public void performUpgrade() {
        pointhandler.addPointsPerSec(0.1f);
    }
}