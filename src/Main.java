import THutil.FileIO.SaveFileLoader;
import THutil.SaveDataLoader;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Timer;

public class Main extends Application {

    private Timer timer;
    private Stage primaryStage;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        this.primaryStage = primaryStage;
        StartScreen startscreen = new StartScreen(this);
        primaryStage.setScene(startscreen.getScene());

        // SHOW SCENE
        primaryStage.show();

    }

    public void launchSinglePlayer(String username){
        timer = new Timer();
        SinglePlayer singleplayer = new SinglePlayer(username,timer,this);
        primaryStage.setScene(singleplayer.getScene());
    }

    @Override
    public void stop() throws Exception {
        if(timer != null) {
            timer.cancel();
        }
        super.stop();
    }
}
