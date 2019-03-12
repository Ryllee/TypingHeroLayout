package Graphics;


import DataEncapsulation.PointData;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

/**
 * Panel som visar information om spelarens poäng.
 * @author Joel Petersson
 * @version 2019-03-12
 */
public class PointCounterPanel extends HBox implements Observer {
    private Text textPoints;
    private Text textTotalPoints;
    private DecimalFormat df;


    /**
     * Konstruktor för PointCounterPanel, skapar allt som ska visas i Panelen
     */
    public PointCounterPanel(){
        super(25);
        setBackground(new Background(new BackgroundFill(Color.web("#2d2d2d"), CornerRadii.EMPTY, Insets.EMPTY)));
        df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        Text staticTextPoints = new Text("Points: ");
        getChildren().add(staticTextPoints);
        staticTextPoints.setFont(Font.font("Helvetica",FontWeight.BOLD, 20));
        staticTextPoints.setFill(Color.WHITE);
        textPoints = new Text("0");
        textPoints.setFont(Font.font("Helvetica",FontWeight.BOLD, 20));
        textPoints.setFill(Color.WHITE);
        getChildren().add(textPoints);

        Text staticTextTotalPoints = new Text("Total points: ");
        staticTextTotalPoints.setFont(Font.font("Helvetica",FontWeight.BOLD, 20));
        staticTextTotalPoints.setFill(Color.WHITE);
        getChildren().add(staticTextTotalPoints);
        textTotalPoints = new Text("0");
        textTotalPoints.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        textTotalPoints.setFill(Color.WHITE);
        getChildren().add(textTotalPoints);
    }

    /**
     *
     * @param o
     * @param arg PointData-objekt som innehåller samlad poäng-data.
     */
    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof PointData){
            Float points = ((PointData) arg).points;
            String stringPoints = df.format(points); // SetText bugged when calling df.format directly
            textPoints.setText(stringPoints);
            Float totalPoints = ((PointData) arg).totalPoints;
            String stringTotalPoints = df.format(totalPoints); // SetText bugged when calling df.format directly
            textTotalPoints.setText(stringTotalPoints);
        }
    }
}
