package Graphics;

import DataEncapsulation.WordData;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;

import java.util.Observable;
import java.util.Observer;

public class WordPanel extends StackPane implements Observer {
    private WordGraphics currentWord;

    public WordPanel() {

    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof WordData){
            switch (((WordData) arg).command){
                case 1:
                    currentWord.correctLetter(((WordData) arg).currentLetterIndex);
                    break;

                case 2:
                    currentWord.incorrectLetter(((WordData) arg).currentLetterIndex);
                    break;

                case 3:
                    getChildren().remove(currentWord);
                    currentWord = new WordGraphics(((WordData) arg).word);
                    currentWord.setAlignment(Pos.CENTER);
                    getChildren().add(currentWord);

                    break;
            }
        }
    }
}
