package com.company;



import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {


    public Group pane = new Group();

    @Override
    public void start(Stage primaryStage) {

        displayHomePage();
        int WIDTH = 800;
        int HEIGHT = 800;
        Scene scene = new Scene(pane , WIDTH, HEIGHT);
        primaryStage.setResizable(false);
        primaryStage.setTitle("PersonalAssistant");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();


//        Thread gameThread = new Thread(() -> {
//            checkers = new Checkers(board);
//            checkers.runGame();
//        });
//        gameThread.setDaemon(false);
//        gameThread.start();
    }
    public void displayHomePage() {

                Rectangle rect = new Rectangle(100,  100, 600, 600);
                rect.setStroke(Color.BLACK);
                rect.setStrokeWidth(3);

                rect.setFill(Color.rgb(200, 200, 200,1.0));

                pane.getChildren().add(rect);



    }





}
