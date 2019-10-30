package Klasser;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Game {
    private Brick[] bricks = Brick.getBrickArray(15);
    private Text step = new Text("0");
    private Button reset = new Button("New Game");
    private GridPane centerGrid = new GridPane();
    private GridPane leftGrid = new GridPane();

    private Brick[] getBricks() { return bricks; }
    public Text getStep(){ return step; }


    public GridPane getLeftGameGrid(){
        Text stepTitel = new Text("Steps taken: ");

        leftGrid.add(stepTitel, 0,0);
        leftGrid.add(step, 1, 0);
        leftGrid.add(reset, 0,1,2,1);
        leftGrid.setAlignment(Pos.CENTER);
        return leftGrid;
    }
    public GridPane getCenterGameGrid(){
        placeBricks();
        centerGrid.setAlignment(Pos.CENTER);
        return centerGrid;
    }
}
