package Graphics;

import javafx.scene.layout.HBox;

public class WordGraphics extends HBox {

    public WordGraphics(String word) {
        char[]characters = word.toCharArray();
        setSpacing(30);
        createLetters(characters);
    }

    private void createLetters(char[] charArray) {
        for (char c : charArray) {
            getChildren().add(new LetterGraphics(c));

        }
    }

    public void correctLetter(int letterIndex) {
        LetterGraphics letter = (LetterGraphics)getChildren().get(letterIndex);
        letter.correct();
    }

    public void incorrectLetter(int letterIndex) {
        LetterGraphics letter = (LetterGraphics)getChildren().get(letterIndex);
        letter.incorrect();
    }
}
