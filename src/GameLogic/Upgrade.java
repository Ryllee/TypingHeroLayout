package GameLogic;

import Notifydata.UpgradeData;

public abstract class Upgrade {
    protected PointHandler pointhandler;
    private String name;
    private String description;
    private float basecost;
    private float costMultiplier;
    private int currentLevel;
    private int maxLevel;

    public Upgrade(PointHandler pointhandler, String name, String description,
                   float basecost, int currentLevel, int maxLevel, float costMultiplier){
        this.pointhandler = pointhandler;
        this.name = name;
        this.description = description;
        this.basecost = basecost;
        this.maxLevel = maxLevel;
        this.currentLevel = currentLevel;
        this.costMultiplier = costMultiplier;
    }


    public boolean purchaseUpgrade(){
        if(currentLevel < maxLevel) {
            System.out.println("pressed");
            if (pointhandler.purchase(getCost())) {
                performUpgrade();
                currentLevel++;
                return true;
            }
            System.out.println("Not enough points");

        } else {
            System.out.println("Max level reached");
        }
        return false;
    }



    public String getName(){
        return name;
    }
    public float getCost(){return (float) (basecost * (Math.pow( costMultiplier, currentLevel)));}
    public int getCurrentLevel() {return currentLevel;}

    public abstract void performUpgrade();
}