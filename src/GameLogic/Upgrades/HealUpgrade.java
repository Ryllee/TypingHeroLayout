package GameLogic.Upgrades;

import GameLogic.HealthHandler;
import GameLogic.PointHandler;
import GameLogic.Upgrade;


public class HealUpgrade extends Upgrade {
    private HealthHandler healthhandler;

    /**
     * Skapar en HealUpgrade
     * @param pointhandler vilken pointhandler den ska känna till
     * @param healthhandler vilken healthandler den ska känna till
     */
    public HealUpgrade(PointHandler pointhandler, HealthHandler healthhandler){
        super(pointhandler, "Heal", "Heal",
                15,0,0, 1f);
        this.healthhandler = healthhandler;
    }

    /**
     * Vad som ska ske när man köpt uppgraderingen
     */
    @Override
    public void performUpgrade() {
        healthhandler.heal(10);
    }
}
