package GameLogic.Upgrades;

import GameLogic.PointHandler;
import GameLogic.Upgrade;
/**
 * Uppgradering som ökar spelarens poäng per bokstav.
 * @author Hedda Ringgren
 * @version 2019-03-12
 */
public class PointsPerLetterUpgrade extends Upgrade {
    /**
     * Skapar en PointsPerLetterUpgrade
     * @param pointhandler vilken pointhandler den ska känna till
     */
    public PointsPerLetterUpgrade(PointHandler pointhandler){
        super(pointhandler, "Increase points per word", "Increase your PointsPerLetter by one",
                10,0,10, 1.5f);


    }

    /**
     * Vad som ska ske när man köpt uppgraderingen
     */
    @Override
    public void performUpgrade() {
        pointhandler.addPointsPerLetter(1.1f);
    }
}