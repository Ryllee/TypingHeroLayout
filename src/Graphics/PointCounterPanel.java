package Graphics;


import Notifydata.PointData;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Observable;
import java.util.Observer;


public class PointCounterPanel extends HBox implements Observer {
    Text textpoints;
    Text texttotalPoints;
    Text statictextpoints;
    Text statictexttotalPoints;

    public PointCounterPanel(){
        super(25);
        statictextpoints = new Text("POINTS: ");
        getChildren().add(statictextpoints);
        statictextpoints.setFont(Font.font("Helvetica", 20));
        textpoints = new Text("0");
        textpoints.setFont(Font.font("Helvetica", 20));
        getChildren().add(textpoints);

        statictexttotalPoints = new Text("TOTALPOINTS: ");
        statictexttotalPoints.setFont(Font.font("Helvetica", 20));
        getChildren().add(statictexttotalPoints);
        texttotalPoints = new Text("0");
        texttotalPoints.setFont(Font.font("Helvetica", 20));
        getChildren().add(texttotalPoints);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof PointData){
            Float points = ((PointData) arg).points;
            textpoints.setText(points.toString());
            Float totalpoints = ((PointData) arg).totalPoints;
            texttotalPoints.setText(totalpoints.toString());
        }
    }
}
