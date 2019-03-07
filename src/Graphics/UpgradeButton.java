package Graphics;

import javafx.scene.control.Button;

public class UpgradeButton extends Button {
    private int index;

    public UpgradeButton(String name, int index) {
        super(name);
        this.index = index;
        setStyle("-fx-background-radius: 10");
    }

    public int getIndex() {
        return index;
    }
}