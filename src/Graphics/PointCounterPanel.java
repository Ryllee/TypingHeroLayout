package Graphics;


import Notifydata.PointData;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.Observable;
import java.util.Observer;


public class PointCounterPanel extends HBox implements Observer {
    Text textpoints;
    Text texttotalPoints;

    public PointCounterPanel(){
        getChildren().add(new Text(" POINTS: "));
        textpoints = new Text("0");
        getChildren().add(textpoints);
        getChildren().add(new Text(" TOTALPOINTS: "));
        texttotalPoints = new Text("0");
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
