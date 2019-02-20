package Graphics;

import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class LetterGraphics extends Text {
    public LetterGraphics(char c) {
        super(String.valueOf(c));
        setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 90));
        ScaleTransition st = new ScaleTransition(Duration.millis(1000), this);
        st.setToY(1.25f);
        st.setToX(1.25f);
        st.setCycleCount(Animation.INDEFINITE);
        st.setAutoReverse(true);
        st.play();
    }

    public void correct() {
        setFill(Color.LIMEGREEN);

    }

    public void incorrect() {
        setFill(Color.RED);

    }
}
