package Graphics;

import Controllers.UpgradeController;
import DataEncapsulation.UpgradeData;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.Observable;
import java.util.Observer;
/**
 * Panel som innehåller uppgraderingsknappar.
 * @author Joel Petersson
 * @version 2019-03-12
 */
public class UpgradePanel extends HBox implements Observer {
    private UpgradeController upgradecontroller;

    /**
     * Skapar en UpgradePanel.
     * @param upgradecontroller UpgradeController som används.
     */
    public UpgradePanel(UpgradeController upgradecontroller) {
        setBackground(new Background(new BackgroundFill(Color.web("#242424"), CornerRadii.EMPTY, Insets.EMPTY)));
        this.upgradecontroller = upgradecontroller;
    }

    /**
     *
     * @param o
     * @param arg UpgradeData-objekt som indikerar vilken uppgradering som skall skapas/uppdateras.
     */
    @Override
    public void update(Observable o, Object arg) {
        if( arg instanceof UpgradeData){
            StringBuilder sb = new StringBuilder();
            if(!((UpgradeData) arg).name.equals("Heal")) { //heal har ingen level
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