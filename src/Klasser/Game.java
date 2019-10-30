package Klasser;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Game {
    private Brick[] bricks;
    private Text step = new Text("0");
    private Button reset = new Button("New Game");
    private GridPane centerGrid = new GridPane();
    private GridPane leftGrid = new GridPane();

    private Brick[] getBricks() { return bricks; }
    public Text getStep(){ return step; }

}
