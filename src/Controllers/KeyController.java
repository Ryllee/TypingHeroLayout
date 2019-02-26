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
        if(!event.getText().equals("")) {
            wordhandler.keyPressed(event.getText());
        }
        else{
            wordhandler.incorrectLetter();
        }
    }
}
