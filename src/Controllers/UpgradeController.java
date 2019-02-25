package Controllers;

import GameLogic.Upgrade;
import GameLogic.UpgradeHandler;
import Graphics.UpgradeButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class UpgradeController implements EventHandler<ActionEvent> {
    private UpgradeHandler upgradehandler;

    public UpgradeController(UpgradeHandler upgradehandler){
        this.upgradehandler = upgradehandler;
    }

    @Override
    public void handle(ActionEvent event) {
        UpgradeButton btn =(UpgradeButton) event.getSource();
        upgradehandler.upgradeButtonPressed(btn.getIndex());
    }
}
