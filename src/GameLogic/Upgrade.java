package GameLogic;

public abstract class Upgrade {
    protected PointHandler points;
    private String name;
    private String description;
    private float cost;
    private int currentLevel;
    private int maxLevel;

    public Upgrade(PointHandler points, String name, String description, float cost, int currentLevel, int maxLevel){
        this.points = points;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.maxLevel = maxLevel;
        this.currentLevel = currentLevel;
    }

    public boolean purchaseUpgrade(){
        if(currentLevel < maxLevel) {
            System.out.println("pressed");
            if (points.purchase(cost)) {
                performUpgrade();
                cost = cost * 1.5f;
                currentLevel++;
                return true;
            }
        }
        return false;
    }

    public String getName(){
        return name;
    }

    public abstract void performUpgrade();
}
