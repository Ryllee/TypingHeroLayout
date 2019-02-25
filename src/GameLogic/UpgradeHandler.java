package GameLogic;

import Notifydata.UpgradeData;

import java.util.ArrayList;
import java.util.Observable;

public class UpgradeHandler extends Observable {
    private ArrayList<Upgrade> upgradelist;

    public UpgradeHandler()
    {
        upgradelist = new ArrayList<Upgrade>();
    }

    public void upgradeButtonPressed(int ButtonIndex){
        Upgrade pressedUpgrade = upgradelist.get(ButtonIndex);
        if(pressedUpgrade.purchaseUpgrade()){
            setChanged();
            notifyObservers(new UpgradeData(ButtonIndex,pressedUpgrade.getCurrentLevel(),pressedUpgrade.getName()));
        }
    }



    public void addUpgrade(Upgrade upgrade){
        upgradelist.add(upgrade);
        int upgradeIndex = upgradelist.size() - 1;
        setChanged();
        notifyObservers(new UpgradeData(upgradeIndex,upgrade.getCurrentLevel(),upgrade.getName()));
    }

}