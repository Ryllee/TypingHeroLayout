package GameLogic;

public abstract class Upgrade {
    protected PointHandler pointhandler;
    private String name;
    private String description;
    private float cost;
    private int currentLevel;
    private int maxLevel;

    public Upgrade(PointHandler pointhandler, String name, String description, float cost, int currentLevel, int maxLevel){
        this.pointhandler = pointhandler;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.maxLevel = maxLevel;
        this.currentLevel = currentLevel;
    }

    public boolean purchaseUpgrade(){
        if(currentLevel < maxLevel) {
            System.out.println("pressed");
            if (pointhandler.purchase(cost)) {
                performUpgrade();
                cost = cost * 1.5f;
                currentLevel++;
                return true;
            }
            System.out.println("Not enough points");
        }
        System.out.println("Max level reached");
        return false;
    }

    public String getName(){
        return name;
    }
    public float getCost(){return cost;}
    public int getcurrentLevel() {return currentLevel;}

    public abstract void performUpgrade();
}
