package Upgrades;

import GameLogic.PointHandler;
import GameLogic.Upgrade;

public class PointsPerLetterUpgrade extends Upgrade {

    public PointsPerLetterUpgrade(PointHandler pointhandler, String name, String description, float cost, int currentLevel, int maxLevel){
        super(pointhandler, name, description, cost, currentLevel, maxLevel);
    }

    @Override
    public void performUpgrade() {
        pointhandler.addPointsPerLetter(1.5f);
    }
}
