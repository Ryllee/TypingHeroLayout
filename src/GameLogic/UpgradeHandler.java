package GameLogic;

import java.util.ArrayList;
import java.util.Observable;

public class UpgradeHandler extends Observable {
    private PointHandler points;
    private ArrayList<Upgrade> upgrades;

    public UpgradeHandler(PointHandler points)
    {
        upgrades = new ArrayList<Upgrade>();
        this.points = points;
    }

    public void upgradeButtonPressed(int ButtonIndex){
        if(upgrades.get(ButtonIndex).purchaseUpgrade()){
            setChanged();
            notifyObservers();
        }
    }

    public void addUpgrade(Upgrade upgrade){
        upgrades.add(upgrade);
        setChanged();
        notifyObservers(upgrade);
    }

}
