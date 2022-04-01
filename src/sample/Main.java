package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static sample.config.Config.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        primaryStage.setMaxWidth(WIDTH);
        primaryStage.setMaxHeight(HEIGHT);
        primaryStage.setTitle("XoX");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        GameController gameController = new GameController(gc, primaryStage);
        gameController.drawCanvas();
        scene.setOnMousePressed(gameController::handleClick);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

