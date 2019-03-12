package Controllers;

import GameLogic.WordHandler;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 * Controller-klass som hanterar tangentbordsinmatning.
 * @author Arvid Holmqvist
 * @version 2019-03-12
 */
public class KeyController implements EventHandler<KeyEvent> {
    private WordHandler wordhandler;

    /**
     * Skapar en KeyController
     * @param wordhandler vilken wordhandler som KeyController ska känna till
     */
    public KeyController(WordHandler wordhandler){
        this.wordhandler = wordhandler;
    }

    /**
     * Vad som ska ske när man tyckt på en tagentbordsknapp
     * @param event den tagenbordsknapp man tryckt
     */
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
