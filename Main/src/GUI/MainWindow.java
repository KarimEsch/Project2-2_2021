package GUI;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainWindow extends Application {


    public Group pane = new Group();
    Processor processor = new Processor();
    Skills currentSkills = new Skills();

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
        Button loadSkills = new Button("Load skill");
        Button saveSkills = new Button("Save skill");
        TextField request = new TextField();
        TextArea chat = new TextArea("Chat with your Personal Assistant \n");
        chat.setOpacity(0.85);
        chat.setTranslateX(80);
        chat.setTranslateY(50);
        chat.setMinHeight(413);
        chat.setMaxHeight(500);
        chat.setMaxWidth(440);
        loadSkills.setTranslateX(140);
        loadSkills.setTranslateY(498);
        saveSkills.setTranslateX(400);
        saveSkills.setTranslateY(498);
        request.setPromptText("write your request here ...");
        request.setTranslateX(226);
        request.setTranslateY(498);
        ask.setTranslateX(260);
        ask.setTranslateY(465);
        ask.setOnAction((event) -> {
            pane.getChildren().add(loadSkills);
            pane.getChildren().add(saveSkills);
            pane.getChildren().add(request);
            pane.getChildren().add(chat);

        });

        saveSkills.setOnAction((event) -> {
            currentSkills.writeSkill(request.getText());
        });

        loadSkills.setOnAction((event) -> {
            currentSkills.getCurrentSkills();
        });

        request.setOnKeyPressed(ke -> {
            if (ke.getCode().equals(KeyCode.ENTER))
            {
                System.out.println("_you entered a request");
                String text = request.getText();
                processor.proceed(text,chat);
                currentSkills.readCurrentSkills();
            }
        });
        ask.setStyle("-fx-background-color: #9a989f; ");
        pane.getChildren().add(ask);


    }

}
