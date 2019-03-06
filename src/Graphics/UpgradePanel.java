package Graphics;

import Controllers.UpgradeController;
import DataEncapsulation.UpgradeData;
import javafx.geometry.Insets;
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
            StringBuilder sb = new StringBuilder();
            if(!((UpgradeData) arg).name.equals("Heal")) {
                sb.append("Level: " + Integer.toString(((UpgradeData) arg).level) + "    ");
            }
            sb.append("Cost: " + ((UpgradeData) arg).cost + "\n");
            sb.append(((UpgradeData) arg).name);
            if (((UpgradeData) arg).index == getChildren().size()) { //new upgrade
                UpgradeButton upgradeButton = new UpgradeButton(sb.toString(), ((UpgradeData) arg).index);
                upgradeButton.setOnAction(upgradecontroller);
                upgradeButton.setPrefHeight(50);
                upgradeButton.setPrefWidth(280);
                getChildren().add(upgradeButton);
                setMargin(upgradeButton,new Insets(5,15,5,15));
            } else {
                UpgradeButton pressed = (UpgradeButton) getChildren().get(((UpgradeData) arg).index);

                pressed.setText(sb.toString());

            }
        }
    }
}