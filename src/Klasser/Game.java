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
        Brick.placeBricks(centerGrid, bricks);
        centerGrid.setAlignment(Pos.CENTER);
        return centerGrid;
    }

    private void increaseStep(){
        step.setText(String.valueOf(Integer.parseInt(step.getText())+1));
    }

    private void checkWin(){
        int n = 0;
        outerLoop:
        for (int x = 0; x<4;x++){
            for (int z = 0; z<4; z++){
                Brick temp = Brick.getBrickFromGridPane(centerGrid, x, z);
                if (temp != null && temp.getNummer() == n+1){
                    n++;
                }else {
                    break outerLoop;
                }
            }
        }
        if (n == bricks.length){
            centerGrid.getChildren().clear();
            centerGrid.add(new Text("You WON!!! \nYour Score: " + (1000-Integer.parseInt(step.getText()))), 0, 0, 5, 5);
        }
    }
}
