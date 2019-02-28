package GameLogic;

import java.util.TimerTask;

public class DamagePerSecondTask extends TimerTask {

    private HealthHandler healthhandler;

    public DamagePerSecondTask(HealthHandler healthhandler) {
        this.healthhandler = healthhandler;
    }
    @Override
    public void run() {
        healthhandler.takeDamage(1);
    }
}
