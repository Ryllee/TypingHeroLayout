package Controllers;

import GameLogic.WordHandler;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyController implements EventHandler<KeyEvent> {
    private WordHandler wordhandler;

    public KeyController(WordHandler wordhandler){
        this.wordhandler = wordhandler;
    }

    @Override
    public void handle(KeyEvent event) {
        wordhandler.keyPressed(event.getText());
    }
}
