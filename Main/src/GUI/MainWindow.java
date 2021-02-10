package GUI;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainWindow extends Application {
    int WIDTH = 1000;
    int HEIGHT = 600;

    public Group pane = new Group();
    Scene scene = new Scene(pane , WIDTH, HEIGHT);
    Processor processor = new Processor();
    Skills currentSkills = new Skills();

    Image image1;
    Image image2;

    Text CurrentTime = new Text();
    Rectangle InputText = new Rectangle();

    Button ask = new Button("Interact With your Assistant");
    Button loadSkills = new Button("Load skill");
    Button saveSkills = new Button("Save skill");
    TextField request = new TextField();
    TextField userDiscussion = new TextField();
    TextArea chat = new TextArea("Chat with your Personal Assistant \n");

    @Override
    public void start(Stage primaryStage) throws IOException{


        //Text CurrentTime = new Text(dtf.format(now));
        CurrentTime.setFill(Color.WHITE);
        CurrentTime.setFont(javafx.scene.text.Font.font(null, FontWeight.BOLD, 20));
        CurrentTime.setStyle("-fx-font-size: 20px;");
        CurrentTime.setTranslateX(50);
        CurrentTime.setTranslateY(45);
        //Creating an image

        image1 = new Image(new FileInputStream("Main/res/MainScreen.png"));
        image2 = new Image(new FileInputStream("Main/res/logo.png"));


        //Setting the image view
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);


        //Setting the position of the image
        imageView1.setX(0);
        imageView1.setY(0);

        imageView2.setX(50);
        imageView2.setY(50);

        //setting the fit height and width of the image view
        imageView1.setFitHeight(600);
        imageView1.setFitWidth(1000);

        imageView2.setFitHeight(500);
        imageView2.setFitWidth(500);

        pane.getChildren().add(imageView1);
        pane.getChildren().add(imageView2);

        pane.getChildren().add(CurrentTime);

        InputText.setTranslateX(570);
        InputText.setTranslateY(463);
        InputText.setHeight(87);
        InputText.setWidth(400);
        InputText.setFill(Color.GRAY);
        InputText.setOpacity(0.7);

        userDiscussion.setTranslateX(680);
        userDiscussion.setTranslateY(493);
        userDiscussion.setPromptText("Ask a request here ...");

        //Chat Area
        chat.setOpacity(0.85);
        chat.setTranslateX(570);
        chat.setTranslateY(50);
        chat.setMinHeight(413);
        chat.setMaxHeight(500);
        chat.setMaxWidth(400);
        //Button to load skills
        loadSkills.setTranslateX(140);
        loadSkills.setTranslateY(498);
        saveSkills.setTranslateX(400);
        saveSkills.setTranslateY(498);
        saveSkills.setOnAction((event) -> currentSkills.writeSkill(request.getText()));

        loadSkills.setOnAction((event) -> currentSkills.getCurrentSkills());

        request.setPromptText("Load or Save Skills ...");
        request.setTranslateX(226);
        request.setTranslateY(498);
        request.setOnKeyPressed(ke -> {
            if (ke.getCode().equals(KeyCode.ENTER))
            {
                System.out.println("_you entered a request");
                String text = request.getText();
                processor.proceed(text,chat);
                currentSkills.readCurrentSkills();
            }
        });

        ask.setTranslateX(220);
        ask.setTranslateY(465);
        ask.setStyle("-fx-background-color: #9a989f; ");
        ask.setOnAction((event) -> {
            pane.getChildren().add(loadSkills);
            pane.getChildren().add(saveSkills);
            pane.getChildren().add(request);
            pane.getChildren().add(chat);
            pane.getChildren().add(InputText);
            pane.getChildren().add(userDiscussion);

        });


        pane.getChildren().add(ask);


        primaryStage.setResizable(false);
        primaryStage.setTitle("PersonalAssistant");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> {
            System.exit(0);
        });

        Thread timerThread = new Thread(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd                                                                             HH:mm:ss");
            while (true) {
                try {
                    Thread.sleep(1000); //1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String time = simpleDateFormat.format(new Date());
                Platform.runLater(() -> {
                    CurrentTime.setText(time);
                });
            }
        });
        timerThread.start();//start the thread and its ok
    }


}
