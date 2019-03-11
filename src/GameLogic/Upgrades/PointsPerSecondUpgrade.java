package GameLogic.Upgrades;

import GameLogic.PointHandler;
import GameLogic.Upgrade;

public class PointsPerSecondUpgrade extends Upgrade {
    /**
     * Skapar en PointsPerSecondUpgrade
     * @param pointhandler vilken pointhandler den ska känna till
     */
    public PointsPerSecondUpgrade(PointHandler pointhandler){
        super(pointhandler, "Increase points per second", "Increase your PointsPerLetter by one",
                20,0,20, 1.5f);
    }

    /**
     * Vad som ska ske när man köpt uppgraderingen
     */
    @Override
    public void performUpgrade() {
        pointhandler.addPointsPerSec(0.1f);
    }
}