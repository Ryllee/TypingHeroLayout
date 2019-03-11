package Graphics;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Observable;
import java.util.Observer;

public class HealthPanel extends StackPane implements Observer {
    private Rectangle greenHP;
    private Rectangle redHP;
    private static double sizeMultiplier = 5;

    /**
     * Konstruktor för HealthPanel, skapar allt som behöves för att visa livspoäng
     */
    public HealthPanel(){
        greenHP = new Rectangle(100*sizeMultiplier,50);
        greenHP.setFill(Color.LIMEGREEN);
        redHP = new Rectangle(100*sizeMultiplier,50);
        redHP.setFill(Color.LIMEGREEN);
        redHP.setOpacity(0.3);

        getChildren().add(redHP);
        getChildren().add(greenHP);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Integer){
            double hpdiff = ((Integer) arg).doubleValue();
            greenHP.setWidth(hpdiff*sizeMultiplier);

        }
    }
}
