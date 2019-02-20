package Graphics;

import Notifydata.WordData;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Observable;
import java.util.Observer;

public class WordPanel extends StackPane implements Observer {
    private Text word;

    public WordPanel() {
        word = new Text("hej");
        word.setFont(Font.font("Comic Sans MS", 35));
        getChildren().add(word);
    }
    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof WordData){
            switch (((WordData) arg).command){
                case 1:
                    word.setFill(Color.LIMEGREEN);
                    break;

                case 2:
                    word.setFill(Color.RED);
                    break;

                case 3:
                    word.setText(((WordData) arg).word);
                    word.setFill(Color.BLACK);
                    break;
            }
        }
    }
}
