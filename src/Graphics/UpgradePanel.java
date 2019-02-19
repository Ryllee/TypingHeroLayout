package Graphics;

import Controllers.UpgradeController;
import GameLogic.Upgrade;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.Observable;
import java.util.Observer;

public class UpgradePanel extends VBox implements Observer {



    @Override
    public void update(Observable o, Object arg) {
        if( arg instanceof Upgrade){
            Button upgradeButton = new Button(((Upgrade) arg).getName());
            upgradeButton.setOnAction(new UpgradeController((Upgrade)arg));
            upgradeButton.setPrefHeight(50);
            getChildren().add(upgradeButton);
        }
    }
}
