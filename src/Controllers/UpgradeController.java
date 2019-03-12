package Controllers;


import GameLogic.UpgradeHandler;
import Graphics.UpgradeButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Controller-klass som hanterar knapptryck på upgradeButton.
 * @author Hedda Ringgren
 * @version 2019-03-12
 */
public class UpgradeController implements EventHandler<ActionEvent> {
    private UpgradeHandler upgradehandler;

    /**
     * Skapar en UpgradeController
     * @param upgradehandler vilken upgradehandler som UpgradeController ska känna till
     */
    public UpgradeController(UpgradeHandler upgradehandler){
        this.upgradehandler = upgradehandler;
    }

    /**
     * Vad som ska ske när man tyckt på en knapp
     * @param event vilken knapp man tyckt på
     */
    @Override
    public void handle(ActionEvent event) {
        UpgradeButton btn =(UpgradeButton) event.getSource();
        upgradehandler.upgradeButtonPressed(btn.getIndex());
    }
}
