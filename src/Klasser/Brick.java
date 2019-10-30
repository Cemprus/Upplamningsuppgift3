package Klasser;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Brick extends Button {
    private int nummer;
    private int row;
    private int col;

    int getNummer() { return nummer; }

    int getRow() { return row; }
    int getCol() { return col; }
    void setPos(int row, int col) {
        this.row = row;
        this.col = col;
    }

    private Brick(int nummer){
        this.nummer = nummer;
        setText(Integer.toString(nummer));
        setPrefSize(50, 50);
    }

    static Klasser.Brick[] getBrickArray(int i){
        Klasser.Brick[] bricks = new Klasser.Brick[i];
        for (int n = 0; n<bricks.length;n++) {
            bricks[n] = new Klasser.Brick(n+1);
        }
        return bricks;
    }

    private void placeBricks(GridPane grid, Brick[] bricks){
        for (Brick brick : bricks) {
            grid.add(brick, brick.getCol(), brick.getRow());
        }
    }
}
