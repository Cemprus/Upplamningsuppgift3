import Klasser.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        Game game = new Game();

        BorderPane border = new BorderPane();

        border.setLeft(game.getLeftGameGrid());
        border.setCenter(game.getCenterGameGrid());

        Scene scene = new Scene(border, 300, 200);

        primaryStage.setTitle("15 Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
