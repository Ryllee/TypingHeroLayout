package Upgrades;

import GameLogic.HealthHandler;
import GameLogic.PointHandler;
import GameLogic.Upgrade;


public class HealUpgrade extends Upgrade {
    private HealthHandler healthhandler;

    public HealUpgrade(PointHandler pointhandler, HealthHandler healthhandler){
        super(pointhandler, "Heal", "Heal",
                15,0,10, 1f);
        this.healthhandler = healthhandler;
    }

    @Override
    public void performUpgrade() {
        healthhandler.heal(10);
    }
}
