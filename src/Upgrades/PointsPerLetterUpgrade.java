package Upgrades;

import GameLogic.PointHandler;
import GameLogic.Upgrade;

public class PointsPerLetterUpgrade extends Upgrade {

    public PointsPerLetterUpgrade(PointHandler points, String name, String description, float cost, int currentLevel, int maxLevel){
        super(points, name, description, cost, currentLevel, maxLevel);
    }

    @Override
    public void performUpgrade() {
        points.addPointsPerLetter(1);
    }
}
