package GameLogic;
import java.util.Observable;

public class HealthHandler extends Observable {
    private int health;
    private int maxHP;
    public HealthHandler(int startHealth, int maxHP) {
        this.health = startHealth;
        this.maxHP = maxHP;
        System.out.println("Health: " + health);
    }

    public void heal(int amount) {
        if (health + amount > maxHP) {
            health = maxHP;
        } else {
            health += amount;
        }
        setChanged();
        notifyObservers(health);
    }

    public void takeDamage(int amount) {
        if (health - amount < 0) {
            health = 0;
        } else {
            health -= amount;
        }
        setChanged();
        notifyObservers(health);
    }
}
