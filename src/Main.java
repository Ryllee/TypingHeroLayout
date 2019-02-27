import javafx.application.Application;
import javafx.stage.Stage;
import java.util.Timer;

public class Main extends Application {

    private Timer timer;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        timer = new Timer();
        SinglePlayer singleplayer = new SinglePlayer("hej",timer);

        primaryStage.setScene(singleplayer.getSinglePlayerScene());
        // SHOW SCENE
        primaryStage.show();


    }


    @Override
    public void stop() throws Exception {
        timer.cancel();
        super.stop();
    }
}
