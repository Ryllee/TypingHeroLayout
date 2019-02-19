package Graphics;

import GameLogic.WordHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.util.Observable;
import java.util.Observer;

public class WordPanel extends StackPane implements Observer {
    private Text letter;

    public WordPanel() {
        letter = new Text("FIRST");
        getChildren().add(letter);
    }
    @Override
    public void update(Observable o, Object arg) {
        letter.setText((String)arg);
    }
}
