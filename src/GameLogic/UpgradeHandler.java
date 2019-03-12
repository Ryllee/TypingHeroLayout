package GameLogic;

import DataEncapsulation.UpgradeData;

import java.util.ArrayList;
import java.util.Observable;
/**
 * Hanterar alla uppgraderingar.
 * @author Joel Petersson
 * @version 2019-03-12
 */
public class UpgradeHandler extends Observable {
    private ArrayList<Upgrade> upgradelist;

    /**
     * Konstuktor för UpgradeHandler, skapar en lista av upgrades
     */
    public UpgradeHandler()
    {
        upgradelist = new ArrayList<Upgrade>();
    }

    /**
     * Kollar vilken Upgrade som ska reagera på trycket
     * @param ButtonIndex vilken knappindex som trycks
     */
    public void upgradeButtonPressed(int ButtonIndex){
        Upgrade pressedUpgrade = upgradelist.get(ButtonIndex);
        if(pressedUpgrade.purchaseUpgrade()){
            setChanged();
            notifyObservers(new UpgradeData(ButtonIndex,pressedUpgrade.getCurrentLevel(),pressedUpgrade.getCost(),pressedUpgrade.getName()));
        }
    }

    /**
     * Skapar en lista av Upgraderingar
     * @return listan av upgraderingar
     */
    public ArrayList<UpgradeData> getUpgradeDataList(){
        ArrayList<UpgradeData> returnList = new ArrayList<>();
        for(int index = 0; index < upgradelist.size(); index++){
            Upgrade current = upgradelist.get(index);
            returnList.add(new UpgradeData(index,current.getCurrentLevel(),current.getCost(),current.getName()));
        }
        return returnList;
    }

    /**
     * Ladda in upgrades data från en lista
     * @param upgradedataList vilken lista datan ska laddas ifrån
     */
    public void loadUpgradeData( ArrayList<UpgradeData> upgradedataList){
        for(UpgradeData ud : upgradedataList){
            upgradelist.get(ud.index).setCurrentLevel(ud.level);
            ud.name = upgradelist.get(ud.index).getName();
            ud.cost = upgradelist.get(ud.index).getCost();
            setChanged();
            notifyObservers(ud);
        }
    }

    /**
     * Lägger till en uppgradering i listan som skapades i konstruktorn
     * @param upgrade vilken uppgradering som ska läggas till
     */
    public void addUpgrade(Upgrade upgrade){
        upgradelist.add(upgrade);
        int upgradeIndex = upgradelist.size() - 1;
        setChanged();
        notifyObservers(new UpgradeData(upgradeIndex,upgrade.getCurrentLevel(),upgrade.getCost(), upgrade.getName()));
    }

}