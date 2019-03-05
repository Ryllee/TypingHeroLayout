package Graphics;


import DataEncapsulation.PointData;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;


public class PointCounterPanel extends HBox implements Observer {
    private Text textPoints;
    private Text textTotalPoints;
    private DecimalFormat df;



    public PointCounterPanel(){
        super(25);
        df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        Text staticTextPoints = new Text("POINTS: ");
        getChildren().add(staticTextPoints);
        staticTextPoints.setFont(Font.font("Comic Sans MS", 20));
        textPoints = new Text("0");
        textPoints.setFont(Font.font("Comic Sans MS", 20));
        getChildren().add(textPoints);

        Text staticTextTotalPoints = new Text("TOTALPOINTS: ");
        staticTextTotalPoints.setFont(Font.font("Comic Sans MS", 20));
        getChildren().add(staticTextTotalPoints);
        textTotalPoints = new Text("0");
        textTotalPoints.setFont(Font.font("Comic Sans MS", 20));
        getChildren().add(textTotalPoints);
    }

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
