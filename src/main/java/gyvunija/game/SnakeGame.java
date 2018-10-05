package gyvunija.game;

import java.io.File;

import gyvunija.Directions;
import gyvunija.Point;
import gyvunija.Snake;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SnakeGame extends Application {

    private static final int SIZE_W = 20;
    private static final int SIZE_H = 20;

    private static final double PIXELS = 20;

    private static final double W_PIXELS = SIZE_W * PIXELS;
    private static final double H_PIXELS = SIZE_H * PIXELS;

    private long lastTick = 0;
    private Directions playerInput = null;
    private boolean gameOn = true;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Snake snake = new Snake(SIZE_W, SIZE_H);

        Canvas canvasSnake = new Canvas(W_PIXELS, H_PIXELS);
        Canvas canvasBg = new Canvas(W_PIXELS, H_PIXELS);
        Canvas canvasObs = new Canvas(W_PIXELS, H_PIXELS);

        GraphicsContext gcSnake = canvasSnake.getGraphicsContext2D();
        GraphicsContext gcBg = canvasBg.getGraphicsContext2D();
        // GraphicsContext gcObs = canvasObs.getGraphicsContext2D();

        Image[] obsticles = new Image[2];
        obsticles[0] = new Image(new File("data/leaf.png").toURI().toString());
        obsticles[1] = new Image(new File("data/leaf2.png").toURI().toString());
        // double obsticleX = -obsticles[0].getWidth();
        // int obsticleImgIndex = 0;

        gcBg.drawImage(new Image("https://media.freestocktextures.com/cache/99/60/9960092a8b6f7f9fd0dcebf7569201f7.jpg"), 0, 0, W_PIXELS, H_PIXELS);
        //https://media.freestocktextures.com/cache/99/60/9960092a8b6f7f9fd0dcebf7569201f7.jpg
        // gcBg.drawImage(new
        // Image("https://g2.dcdn.lt/images/pix/iskander-sparnuotosios-raketos-paleidimas-72087510.jpg"),
        // 0, 0, W_PIXELS, H_PIXELS);
        Pane root = new Pane(canvasBg, canvasSnake);

        Scene scene = new Scene(root);
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        // primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Snake 0.8 alfa");
        primaryStage.setMinWidth(W_PIXELS);
        primaryStage.setMinHeight(H_PIXELS);
        // primaryStage.setFullScreen(true);

        primaryStage.setScene(scene);
        primaryStage.show();

        long startTime = System.currentTimeMillis();

        (new AnimationTimer() {

            @Override
            public void handle(long currentTimeNanos) {

                if(!gameOn){
                    System.out.println("zaidimas baigtas");
                    System.exit(0);
                }

                long tick = (currentTimeNanos - startTime) / 1000000000L;

                if (lastTick != tick) {

                    if (playerInput != null) {
                        gameOn = snake.move(playerInput);
                    } else {
                        gameOn = snake.move();
                    }

                    lastTick = tick;
                }

                // Issivalom viska
                gcSnake.clearRect(0, 0, W_PIXELS, H_PIXELS);

                // Supaisom per naujo gyvatele
                for (Point point : snake.getPoints()) {

                    // Paisom gyvates nareli
                    drawJoint(point, gcSnake);
                }

//                for (Point head : snake.getPoints()) {
//
//                    // Paisom gyvates nareli
//                    drawHead(head, gcSnake);
//                }

            }
        }).start();

        scene.setOnKeyPressed((evt) -> {

            if (KeyCode.LEFT.equals(evt.getCode())) {
                playerInput = Directions.LEFT;
            }

            if (KeyCode.RIGHT.equals(evt.getCode())) {
                playerInput = Directions.RIGHT;
            }

            if (KeyCode.UP.equals(evt.getCode())) {
                playerInput = Directions.UP;
            }

            if (KeyCode.DOWN.equals(evt.getCode())) {
                playerInput = Directions.DOWN;
            }

            if (KeyCode.ESCAPE.equals(evt.getCode())) {
                System.exit(0);
            }

        });

    }

    private void drawJoint(Point point, GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(1);
        gc.fillRoundRect(PIXELS * point.getX(), PIXELS * point.getY(), PIXELS, PIXELS, 15, 15);
    }

    private void drawHead(Point head, GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(1);
        gc.fillRoundRect(PIXELS * head.getX(), PIXELS * head.getY(), PIXELS, PIXELS, 15, 15);
    }


}