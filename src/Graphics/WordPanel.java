package Graphics;

import DataEncapsulation.WordData;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.Observable;
import java.util.Observer;

/**
 * Panel som innehåller den grafiska reprresentationen av det nuvarande ordet.
 * @author Joel Petersson
 * @version 2019-03-12
 */
public class WordPanel extends StackPane implements Observer {
    private WordGraphics currentWord;

    /**
     * Skapar panelen.
     */
    public WordPanel() {
        setBackground(new Background(new BackgroundFill(Color.web("#3a3a3a"), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    /**
     * Utför olika operationer på currentWord beroende på vilket kommando som skickas med i WordData-objektet.
     * @param o
     * @param arg WordData-objekt som avgör operation.
     */
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
