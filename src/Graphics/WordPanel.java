package Graphics;

import Notifydata.WordData;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

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
                    try {
                        getChildren().remove(currentWord); //Needs to catch index out of bounds on first word, not initialized
                    } catch (IndexOutOfBoundsException e) {

                    }
                    currentWord = new WordGraphics(((WordData) arg).word);
                    currentWord.setAlignment(Pos.CENTER);
                    getChildren().add(currentWord);

                    break;
            }
        }
    }
}
