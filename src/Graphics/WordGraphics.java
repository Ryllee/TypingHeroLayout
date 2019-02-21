package Graphics;

import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class WordGraphics extends HBox {

    private SequentialTransition incorrectAnimation;

    public WordGraphics(String word) {
        char[]characters = word.toCharArray();
        setSpacing(30);
        createLetters(characters);
        createAnimations();
    }

    private void createLetters(char[] charArray) {
        for (char c : charArray) {
            getChildren().add(new LetterGraphics(c));

        }
    }

    private void createAnimations() {
        RotateTransition rotateStartAnimation = new RotateTransition(Duration.millis(50), this);
        rotateStartAnimation.setToAngle(-5);
        rotateStartAnimation.setCycleCount(0);

        RotateTransition rotateAnimation = new RotateTransition(Duration.millis(100), this);
        rotateAnimation.setToAngle(5);
        rotateAnimation.setCycleCount(3);
        rotateAnimation.setAutoReverse(true);

        RotateTransition rotateEndAnimation = new RotateTransition(Duration.millis(50), this);
        rotateEndAnimation.setToAngle(0);
        rotateEndAnimation.setCycleCount(0);

        incorrectAnimation = new SequentialTransition(this, rotateStartAnimation, rotateAnimation, rotateEndAnimation);
    }

    public void correctLetter(int letterIndex) {
        LetterGraphics letter = (LetterGraphics)getChildren().get(letterIndex);
        letter.correct();
    }

    public void incorrectLetter(int letterIndex) {
        LetterGraphics letter = (LetterGraphics)getChildren().get(letterIndex);
        letter.incorrect();
        incorrectAnimation.play();
    }
}
