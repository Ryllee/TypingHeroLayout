package Controllers;

import GameLogic.Upgrade;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class UpgradeController implements EventHandler<ActionEvent> {
    private Upgrade upgrade;

    public UpgradeController(Upgrade upgrade){
        this.upgrade = upgrade;
    }

    @Override
    public void handle(ActionEvent event) {
        upgrade.purchaseUpgrade();
    }
}
