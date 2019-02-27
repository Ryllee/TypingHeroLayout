import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;


public class StartScreen {
    private GridPane mainWindow;
    private Main main;

    public StartScreen(Main main){
        mainWindow = new GridPane();
        setConstraints(mainWindow);
        this.main=main;
        Label label = new Label("     Username:");
        TextField usernameinput = new TextField();
        Button start = new Button("Start SinglePlayer");
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!usernameinput.getText().equals("")) {
                    main.launchSinglePlayer(usernameinput.getText());
                }
            }
        });
        mainWindow.add(label,0,1);
        mainWindow.add(usernameinput,1,1);
        mainWindow.add(start,1,2);
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
