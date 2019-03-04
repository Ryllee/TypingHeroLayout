package Graphics;

import Controllers.UpgradeController;
import Notifydata.UpgradeData;
import javafx.scene.layout.HBox;

import java.util.Observable;
import java.util.Observer;

public class UpgradePanel extends HBox implements Observer {
    private UpgradeController upgradecontroller;
    public UpgradePanel(UpgradeController upgradecontroller) {
        this.upgradecontroller = upgradecontroller;
    }


    @Override
    public void update(Observable o, Object arg) {
        if( arg instanceof UpgradeData){
            if (((UpgradeData) arg).index == getChildren().size()) { //new upgrade
                UpgradeButton upgradeButton = new UpgradeButton(((UpgradeData) arg).name, ((UpgradeData) arg).index);
                upgradeButton.setOnAction(upgradecontroller);
                upgradeButton.setPrefHeight(50);
                getChildren().add(upgradeButton);
            }
        }
    }
}