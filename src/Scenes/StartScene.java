package Scenes;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;



/**
 * Första scenen som visas. Ger spelaren val om att starta spelet eller att visa highscore.
 * @author Elma Esati
 * @version 2019-03-12
 */
public class StartScene {
    private GridPane mainWindow;

    /**
     * Konstruktor för StartScene skapar allt som behöves i startscene
     */
    public StartScene(){
        mainWindow = new GridPane();
        setConstraints(mainWindow);

        Label label = new Label("     Username:");
        TextField usernameinput = new TextField();
        Button start = new Button("Start SinglePlayer");
        Button highscorebutton = new Button("Highscore");
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!usernameinput.getText().equals("")) {
                    Main.launchSinglePlayer(usernameinput.getText());
                }
            }
        });
        highscorebutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.launchHighscore();
            }
        });
        mainWindow.add(label,0,1);
        mainWindow.add(usernameinput,1,1);
        mainWindow.add(start,1,2);
        mainWindow.add(highscorebutton,1,3);
    }

    /**
     * Skapar en scene av StartScene
     * @return en scene av StartScene
     */
    public Scene getScene(){
        return new Scene(mainWindow,390,390);
    }

    /**
     * Sätter layouten för StartScene
     * @param mainWindow är vilken Pane som layouten ska sättas på
     */
    private void setConstraints(GridPane mainWindow){
        mainWindow.getColumnConstraints().add(new ColumnConstraints(130));
        mainWindow.getColumnConstraints().add(new ColumnConstraints(130));
        mainWindow.getColumnConstraints().add(new ColumnConstraints(130));
        mainWindow.getRowConstraints().add(new RowConstraints(60));
        mainWindow.getRowConstraints().add(new RowConstraints(60));
        mainWindow.getRowConstraints().add(new RowConstraints(60));
    }

}
