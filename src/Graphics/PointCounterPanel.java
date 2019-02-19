package Graphics;

import GameLogic.PointHandler;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.Observable;
import java.util.Observer;


public class PointCounterPanel extends HBox implements Observer {
    Text points;
    Text totalPoints;

    public PointCounterPanel(){
        points = new Text("0");
        totalPoints = new Text("0");
        getChildren().add(points);
        getChildren().add(totalPoints);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof PointHandler){
            Float f = ((PointHandler) arg).getPoints();
            points.setText(f.toString());
        }
    }
}
