package Controllers.MenubarControllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SaveLocalController implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        System.out.println("Save Local pressed");
    }
}
