package Graphics;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Observable;
import java.util.Observer;

/**
 * Panel som innehåller grafisk representation av livspoäng.
 * @author Joel Petersson
 * @version 2019-03-12
 */
public class HealthPanel extends StackPane implements Observer {
    private Rectangle greenHP;
    private Rectangle maxHP;
    private static double sizeMultiplier = 5;

    /**
     * Konstruktor för HealthPanel, skapar allt som behöves för att visa livspoäng
     */
    public HealthPanel(){
        greenHP = new Rectangle(100*sizeMultiplier,50);
        greenHP.setFill(Color.LIMEGREEN);
        maxHP = new Rectangle(100*sizeMultiplier,50);
        maxHP.setFill(Color.LIMEGREEN);
        maxHP.setOpacity(0.3);

        getChildren().add(maxHP);
        getChildren().add(greenHP);
    }

    /**
     * Tar emot ett heltal som beskriver nuvarande livspoängen.
     * @param o
     * @param arg nuvarande livspoäng
     */
    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Integer){
            double hpdiff = ((Integer) arg).doubleValue();
            greenHP.setWidth(hpdiff*sizeMultiplier);

        }
    }
}
