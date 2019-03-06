package Upgrades;

import GameLogic.PointHandler;
import GameLogic.Upgrade;

public class PointsPerLetterUpgrade extends Upgrade {

    public PointsPerLetterUpgrade(PointHandler pointhandler){
        super(pointhandler, "Increase points per word", "Increase your PointsPerLetter by one",
                10,0,10, 1.5f);


    }

    @Override
    public void performUpgrade() {
        pointhandler.addPointsPerLetter(1.1f);
    }
}