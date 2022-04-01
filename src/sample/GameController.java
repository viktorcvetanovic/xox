package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.data.Field;
import sample.data.Player;
import sample.data.Type;

import java.util.ArrayList;
import java.util.List;

import static sample.config.Config.*;

public class GameController {
    private Stage primaryStage;
    private GraphicsContext gc;
    private List<Field> fieldList = new ArrayList<>();
    private Player playerOne;
    private Player playerTwo;

    public GameController(GraphicsContext gc, Stage primaryStage) {
        this.gc = gc;
        this.primaryStage = primaryStage;
    }

    /**
     * this method is used to handle every interaction made
     * bu the player
     *
     * @param event event from javafx
     */
    public void handleClick(MouseEvent event) {
        int x = (int) (event.getX() / SQUARE_SIZE);
        int y = (int) (event.getY() / SQUARE_SIZE);
        drawFigure(x, y, Type.O);

    }

    /**
     * this is called only once on the start of the game
     * to draw canvas to be played
     */
    public void drawCanvas() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if ((i + j) % 2 == 0) {
                    gc.setFill(Color.BLACK);
                } else {
                    gc.setFill(Color.WHITE);
                }
                gc.fillRect(i * SQUARE_SIZE, j * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                fieldList.add(new Field(true, null, i, j));
            }
        }
    }

    /**
     * we use this to draw specific figure type on some coordinate
     * we will change field on that coordinate too
     * so we dont lose information about it
     *
     * @param x    coordinate x
     * @param y    coordinate y
     * @param type figure type ENUM
     */
    private void drawFigure(int x, int y, Type type) {
        if (type == Type.X) {
            gc.setFill(Color.GREEN);
        } else if (type == Type.O) {
            gc.setFill(Color.YELLOW);
        }
        gc.fillRect(x * SQUARE_SIZE, y * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
        Field field = findFieldByCoordinates(x, y);
        field.setEmpty(false);
        field.setType(type);
    }

    //UTIL METHODS

    /**
     * we are finding field by coordinates
     * and if we dont find we will throw an exception
     *
     * @param x coordinate x
     * @param y coordinate y
     * @return found field by coordinates
     */
    private Field findFieldByCoordinates(int x, int y) {
        return fieldList.stream().filter(e -> e.getX() == x && e.getY() == y)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Could not find the field on that coordinates"));
    }

    /**
     * we use this method to randomly set players type on
     * the start of the game
     */
    private void randomSetPlayerType() {
        if (getRandomBoolean()) {
            playerOne.setType(Type.O);
            playerTwo.setType(Type.X);
        } else {
            playerOne.setType(Type.X);
            playerTwo.setType(Type.O);
        }
    }

    /**
     * like the name says we are generating random boolean
     *
     * @return random boolean
     */
    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }
}
