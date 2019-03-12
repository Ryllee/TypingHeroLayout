package DataEncapsulation;



public class UpgradeData {
    public int index;
    public int level;
    public float cost;
    public String name;

    /**
     * Skapar en UpgradeData utan kostand
     * @param index uppgraderingens index
     * @param level uppgraderingens level
     * @param name uppgraderingens namn
     */
    public UpgradeData(int index, int level, String name) {
        this.index = index;
        this.level = level;
        this.name = name;
    }

    /**
     * Skapar en UpgradeData med kostnad
     * @param index uppgraderingens index
     * @param level uppgraderingens level
     * @param cost uppgraderingens kostnad
     * @param name uppgraderingens namn
     */
    public UpgradeData(int index, int level, float cost, String name) {
        this.index = index;
        this.level = level;
        this.cost = cost;
        this.name = name;
    }

}