package Klasser;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.Arrays;
import java.util.Collections;

class Brick extends Button {
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

    static void placeBricks(GridPane grid, Brick[] bricks){
        for (Brick brick : bricks) {
            grid.add(brick, brick.getCol(), brick.getRow());
        }
    }

    static Klasser.Brick getBrickFromGridPane(GridPane grid, int row, int col) {
        for (Node node : grid.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row && node instanceof Klasser.Brick) {
                return (Klasser.Brick) node;
            }
        }
        return null;
    }

    static void moveBrickInGridPane(GridPane grid, Object node, int rowNum, int colNum){
        ((Klasser.Brick) node).setPos(rowNum, colNum);
        grid.getChildren().remove(node);
        grid.add((Klasser.Brick) node,colNum, rowNum);
    }

    static void shuffleBricksInArray(Klasser.Brick[] bricks) {
        Collections.shuffle(Arrays.asList(bricks));

        for (int n = 0;n<bricks.length;n++){
            if(n < 4){
                bricks[n].setPos(0, n);
            }else if (n<8){
                bricks[n].setPos(1, n-4);
            }else if (n<12){
                bricks[n].setPos(2, n-8);
            }else if (n<16){
                bricks[n].setPos(3, n-12);
            }
        }
    }
}
