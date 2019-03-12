package GameLogic;
/**
 * Abstrakt klass som för uppgraderingar.
 * @author Joel Petersson
 * @version 2019-03-12
 */
public abstract class Upgrade {
    protected PointHandler pointhandler;
    private String name;
    private String description;
    private float basecost;
    private float costMultiplier;
    private int currentLevel;
    private int maxLevel;

    /**
     * Skapar en uppgradering
     * @param pointhandler vilken pointhandler den ska känna till
     * @param name vilket namn uppgraderingen har
     * @param description en beskrivning av uppgraderingen
     * @param basecost startkostnaden för uppgraderingen
     * @param currentLevel nuvarande level
     * @param maxLevel max level
     * @param costMultiplier vad kostnanden ska multipliceras med för varje level
     */
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

    /**
     * Kollar om man kan köpa en uppgradering
     * @return om den kunde köpas eller inte
     */
    public boolean purchaseUpgrade(){
        if(currentLevel < maxLevel || maxLevel == 0) {
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


    /**
     * Hämtar namnet på en uppgraderingen
     * @return nament på en uppgraderingen
     */
    public String getName(){
        return name;
    }

    /**
     * Hämta nuvarande kostnaden av en uppgraderingen
     * @return nuvarande kostnaden av en uppgraderingen
     */
    public float getCost(){return (float) (basecost * (Math.pow( costMultiplier, currentLevel)));}

    /**
     * Hämtar nuvarande level för en uppgradering
     * @return nuvarande level för en uppgradering
     */
    public int getCurrentLevel() {return currentLevel;}

    /**
     * Sätter level på en uppgradering
     * @param level vilken level som uppgraderingen ska få
     */
    public void setCurrentLevel(int level){
        currentLevel = level;
    }

    /**
     * Vad som ska ske när en uppgradering köps
     */
    public abstract void performUpgrade();
}