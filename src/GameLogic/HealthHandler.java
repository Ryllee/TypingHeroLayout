package GameLogic;

import Scenes.SinglePlayer;

import java.util.Observable;

public class HealthHandler extends Observable {
    private int health;
    private int maxHP;

    /**
     * Skapar en HealthHandler
     * @param startHealth vilket livspoäng man ska starta på
     * @param maxHP vilket ens max livspoäng är
     */
    public HealthHandler(int startHealth, int maxHP) {
        this.health = startHealth;
        this.maxHP = maxHP;
        System.out.println("Health: " + health);
    }

    /**
     * Det som ska ske när man får mer liv
     * @param amount hur mycket mer liv man ska få
     */
    public void heal(int amount) {
        if (health + amount > maxHP) {
            health = maxHP;
        } else {
            health += amount;
        }
        setChanged();
        notifyObservers(health);
    }

    /**
     * Det som ska ske när man tar skada
     * @param amount hur mycket liv man ska förlora
     */
    public void takeDamage(int amount) {
        if (health - amount < 0) {
            health = 0;
            SinglePlayer.gameOver();
        } else {
            health -= amount;
            setChanged();
            notifyObservers(health);
        }
    }
}
