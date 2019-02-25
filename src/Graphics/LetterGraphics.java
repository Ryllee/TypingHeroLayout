package Graphics;

import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class LetterGraphics extends Text {
    private ScaleTransition idleAnimation;
    public LetterGraphics(char c) {
        super(String.valueOf(c));
        setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 90));
        createAnimations();
        idleAnimation.play();
    }

    public void correct() {
        //TODO: Maybe animation here?
        setFill(Color.LIMEGREEN);
    }

    public void incorrect() {
        //TODO: And here?
        setFill(Color.RED);
    }

    private void createAnimations() {
        // Idle
        idleAnimation = new ScaleTransition(Duration.millis(1000), this);
        idleAnimation.setToY(1.25f);
        idleAnimation.setToX(1.25f);
        idleAnimation.setCycleCount(Animation.INDEFINITE);
        idleAnimation.setAutoReverse(true);
        //TODO: add more animations?
    }
}
