package DataEncapsulation;



public class UpgradeData {
    public int index;
    public int level;
    public float cost;
    public String name;

    public UpgradeData(int index, int level, String name) {
        this.index = index;
        this.level = level;
        this.name = name;
    }

    public UpgradeData(int index, int level, float cost, String name) {
        this.index = index;
        this.level = level;
        this.cost = cost;
        this.name = name;
    }

}