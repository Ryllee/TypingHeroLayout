import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class StartScreen {
    private StackPane mainWindow;
    private Main main;

    public StartScreen(Main main){
        mainWindow = new StackPane();
        this.main=main;

        Button start = new Button("Start SinglePlayer");
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                main.launchSinglePlayer();
            }
        });

        mainWindow.getChildren().add(start);
    }

    public Scene getScene(){
        return new Scene(mainWindow,400,400);
    }
}
