import THutil.Network.Client;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.LinkedHashMap;
import java.util.Set;


public class StartScene {
    private GridPane mainWindow;
    private Main main;

    public StartScene(Main main){
        mainWindow = new GridPane();
        setConstraints(mainWindow);
        this.main=main;
        Label label = new Label("     Username:");
        TextField usernameinput = new TextField();
        Button start = new Button("Start SinglePlayer");
        Button highscorebutton = new Button("Highscore");
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!usernameinput.getText().equals("")) {
                    main.launchSinglePlayer(usernameinput.getText());
                }
            }
        });
        highscorebutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                main.launchHighscore();
            }
        });
        mainWindow.add(label,0,1);
        mainWindow.add(usernameinput,1,1);
        mainWindow.add(start,1,2);
        mainWindow.add(highscorebutton,1,3);
    }

    public Scene getScene(){
        return new Scene(mainWindow,390,390);
    }

    private void setConstraints(GridPane mainWindow){
        mainWindow.getColumnConstraints().add(new ColumnConstraints(130));
        mainWindow.getColumnConstraints().add(new ColumnConstraints(130));
        mainWindow.getColumnConstraints().add(new ColumnConstraints(130));
        mainWindow.getRowConstraints().add(new RowConstraints(60));
        mainWindow.getRowConstraints().add(new RowConstraints(60));
        mainWindow.getRowConstraints().add(new RowConstraints(60));
    }

}
