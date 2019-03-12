package Graphics;

import javafx.animation.*;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
/**
 * Grafisk representation av en enskild bokstav.
 * @author Joel Petersson
 * @version 2019-03-12
 */
public class LetterGraphics extends Text {
    private ScaleTransition idleAnimation;
    private ParallelTransition correctAnimation;
    private FillTransition incorrectAnimation;

    /**
     * Skapar en instans av LetterGraphics
     * @param c vilken bokstav som ska visas
     */
    public LetterGraphics(char c) {
        super(String.valueOf(c));
        setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 90));
        setFill(Color.WHITE);

        createAnimations();
        createReflection();
        idleAnimation.play();
    }

    /**
     * Spelar upp animation som indikerar att bokstaven har skrivits rätt.
     */
    public void correct() {
        incorrectAnimation.stop();
        correctAnimation.play();
    }

    /**
     * Spelar upp animation som indikerar att bokstaven har skrivits fel.
     */
    public void incorrect() {
        incorrectAnimation.play();
    }

    /**
     * Skapar reflektionseffekt.
     */
    private void createReflection() {
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        r.setTopOpacity(0.2f);
        r.setBottomOpacity(0.01f);
        setEffect(r);
    }

    /**
     * Skapar animationer.
     */
    private void createAnimations() {
        // Idle
        idleAnimation = new ScaleTransition(Duration.millis(1000), this);
        idleAnimation.setToY(1.25f);
        idleAnimation.setToX(1.25f);
        idleAnimation.setCycleCount(Animation.INDEFINITE);
        idleAnimation.setAutoReverse(true);

        //Correct
        ScaleTransition startCorrectAnimation = new ScaleTransition(Duration.millis(150), this);
        startCorrectAnimation.setToX(1.5f);
        startCorrectAnimation.setToY(1.5f);
        startCorrectAnimation.setCycleCount(2);
        startCorrectAnimation.setAutoReverse(true);

        FillTransition correctFillAnimaion = new FillTransition(Duration.millis(150), this,Color.WHITE,Color.LIMEGREEN);
        correctFillAnimaion.setCycleCount(1);

        correctAnimation = new ParallelTransition(this,startCorrectAnimation, correctFillAnimaion);

        //Incorrect
        incorrectAnimation = new FillTransition(Duration.millis(200), this,Color.WHITE,Color.RED);
        incorrectAnimation.setCycleCount(5);
        incorrectAnimation.setAutoReverse(true);

    }
}
