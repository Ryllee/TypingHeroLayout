package GameLogic;

import java.util.ArrayList;
import java.util.Observable;

public class UpgradeHandler extends Observable {
    private ArrayList<Upgrade> upgradelist;

    public UpgradeHandler()
    {
        upgradelist = new ArrayList<Upgrade>();
    }

    public void upgradeButtonPressed(int ButtonIndex){
        if(upgradelist.get(ButtonIndex).purchaseUpgrade()){
            setChanged();
            notifyObservers();

        }
    }

    public void addUpgrade(Upgrade upgrade){
        upgradelist.add(upgrade);
        setChanged();
        notifyObservers(upgrade);
    }

}
