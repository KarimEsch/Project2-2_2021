package GUI;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainWindow extends Application {


    public Group pane = new Group();

    @Override
    public void start(Stage primaryStage) {

        displayHomePage();
        int WIDTH = 600;
        int HEIGHT = 550;
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



        //Creating an image
        Image image = null;
        try {
            image = new Image(new FileInputStream("Main/res/logo.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Setting the image view
        ImageView imageView = new ImageView(image);

        //Setting the position of the image
        imageView.setX(50);
        imageView.setY(25);

        //setting the fit height and width of the image view
        imageView.setFitHeight(500);
        imageView.setFitWidth(500);

        pane.getChildren().add(imageView);

        Button ask = new Button("Ask a request");
        ask.setTranslateX(260);
        ask.setTranslateY(465);
        ask.setOnAction((event) -> {
            System.out.println("Button clicked!");
            TextField request = new TextField();
            request.setPromptText("write your request here ...");
            request.setTranslateX(226);
            request.setTranslateY(498);
            pane.getChildren().add(request);

        });

        ask.setStyle("-fx-background-color: #9a989f; ");
        pane.getChildren().add(ask);



    }





}
