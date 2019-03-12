package Graphics;

import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 * Klass som samlar LetterGraphics till ett sammanhängande ord.
 * @author Joel Petersson
 * @version 2019-03-12
 */
public class WordGraphics extends HBox {

    private SequentialTransition incorrectAnimation;

    /**
     * Skapar en instans av WordGraphics
     * @param word ordet som skall representeras grafiskt
     */
    public WordGraphics(String word) {
        char[]characters = word.toCharArray();
        setSpacing(30);
        createLetters(characters);
        createAnimations();
    }

    /**
     * Skapar en LetterGraphic för varje char i charArray
     * @param charArray Array med chars som ska användas för att skapa LetterGraphics
     */
    private void createLetters(char[] charArray) {
        for (char c : charArray) {
            getChildren().add(new LetterGraphics(c));

        }
    }

    /**
     * Skapar animationer.
     */
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

    /**
     * Startar korrekt-animationen på en LetterGraphics
     * @param letterIndex index som indikerar vilken bokstav som berörs.
     */
    public void correctLetter(int letterIndex) {
        LetterGraphics letter = (LetterGraphics)getChildren().get(letterIndex);
        letter.correct();
    }
    /**
     * Startar inkorrekt-animationen på en LetterGraphics samt sin egen sådan animation.
     * @param letterIndex index som indikerar vilken bokstav som berörs.
     */
    public void incorrectLetter(int letterIndex) {
        LetterGraphics letter = (LetterGraphics)getChildren().get(letterIndex);
        letter.incorrect();
        incorrectAnimation.play();
    }
}
