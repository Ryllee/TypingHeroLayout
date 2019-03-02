package Graphics;

import javafx.scene.layout.BorderPane;

public class MultiplayerGUI extends BorderPane {

    public MultiplayerGUI(WordPanel wordPanel) {
        setCenter(wordPanel);
    }
}
