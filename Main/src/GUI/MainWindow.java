package GUI;


import Processing.JSONReadFromFile;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Processing.JSONWriteInFile.appendActivity;


public class MainWindow extends Application {

    //FaceDetection face = new FaceDetection();
    Group pane = new Group();
    Group secondaryLayout = new Group();
    Scene scene = new Scene(pane, 1000, 600);
    Scene secondScene = new Scene(secondaryLayout, 650, 150);
    Stage newWindow = new Stage();
    Processor processor = new Processor();
    Skills currentSkills = new Skills();

    JSONReadFromFile reader = new JSONReadFromFile("currentActivities");

    Image image1;
    Image image2;

    Text CurrentTime = new Text();
    Rectangle InputText = new Rectangle();

    Button ask = new Button("Interact With your Assistant");
    Button loadSkills = new Button("Load skill");
    Button saveSkills = new Button("Save skill");
    Button newSkill = new Button("New Skill");
    TextField request = new TextField();
    TextField you_entered_a_request = new TextField();

    Label question = new Label("Question : ");
    Button save = new Button("Save");
    TextField question_field = new TextField();
    Label action = new Label("Action : ");
    Label namefile = new Label("Save file as : ");
    TextField user_skill_input = new TextField();
    TextField skill_code1 = new TextField();
    TextField skill_code2 = new TextField();
    TextField skill_code3 = new TextField();
    ComboBox name = new ComboBox();
    TextArea chat = new TextArea("Chat with your Personal Assistant \n");
    TextArea currentSkillsDisplayed = new TextArea();



    @Override
    public void start(Stage primaryStage) throws IOException {


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

        name.setTranslateX(250);
        name.setPrefSize(190,20);
        name.setEditable(true);
        namefile.setTranslateX(150);
        save.setTranslateX(465);

        pane.getChildren().add(imageView1);
        pane.getChildren().add(imageView2);
        pane.getChildren().add(CurrentTime);

        InputText.setTranslateX(570);
        InputText.setTranslateY(463);
        InputText.setHeight(87);
        InputText.setWidth(400);
        InputText.setFill(Color.GRAY);
        InputText.setOpacity(0.7);

        you_entered_a_request.setTranslateX(680);
        you_entered_a_request.setTranslateY(493);
        you_entered_a_request.setPromptText("Digital assistant reply");

        //Chat Area
        chat.setOpacity(0.85);
        chat.setTranslateX(570);
        chat.setTranslateY(50);
        chat.setMinHeight(413);
        chat.setMaxHeight(500);
        chat.setMaxWidth(400);

        //Button to load/save/new skills
        loadSkills.setTranslateX(120);
        loadSkills.setTranslateY(500);
        saveSkills.setTranslateX(400);
        saveSkills.setTranslateY(500);
        newSkill.setTranslateX(260);
        newSkill.setTranslateY(550);
        saveSkills.setOnAction((event) -> currentSkills.writeSkill(request.getText()));

        loadSkills.setOnAction((event) -> {
                    currentSkills.readCurrentSkills();
                    currentSkills.getCurrentSkills();
                    reader.parseSkills();
                    Stage LoadSkillsStage = new Stage();

                    VBox box = new VBox();
                    box.setPadding(new Insets(10));

                    // How to center align content in a layout manager in JavaFX
                    box.setAlignment(Pos.CENTER);
                    Label label = new Label("Enter username and password");

                    currentSkillsDisplayed.setMinHeight(450);
                    currentSkillsDisplayed.setMaxWidth(450);
                    currentSkillsDisplayed=processor.readFromFileIntoTextArea("Main/res/currentSkills.csv");

                    box.getChildren().add(label);
                    box.getChildren().add(currentSkillsDisplayed);
                    Scene scene = new Scene(box, 500, 500);
                    LoadSkillsStage.setScene(scene);
                    LoadSkillsStage.show();
                }
        );

        try {
            File f = new File("Main/res/skills");
            for (int i = 0; i < f.list().length; i++) {
                String str = f.list()[i];
                String strNew = str.substring(0, str.length() - 4);
                name.getItems().add(strNew);
            }
        }catch(Exception e){
            System.out.println(e);
        }

        newSkill.setOnAction((event) -> {
                    question.setTranslateX(10);
                    question.setTranslateY(50);
                    question_field.setTranslateX(100);
                    question_field.setTranslateY(50);
                    question_field.setPrefWidth(500);
                    question_field.setOnKeyPressed(e -> {
                        if (e.getCode().equals(KeyCode.ENTER)) {
                            newWindow.setHeight(400);
                            countArrow(question_field.getText(), secondaryLayout, save, action, user_skill_input, skill_code1, skill_code2, skill_code3, namefile, name);
                        }
                    });
                    action.setTranslateX(10);
                    user_skill_input.setTranslateX(100);
                    user_skill_input.setPrefWidth(500);

                    secondaryLayout.getChildren().add(question);
                    secondaryLayout.getChildren().add(question_field);

                    newWindow.setTitle("New skill");
                    newWindow.setScene(secondScene);
                    newWindow.initModality(Modality.WINDOW_MODAL);
                    newWindow.initOwner(primaryStage);
                    newWindow.show();
                }
        );

        save.setOnAction(E -> {
            try {
                String filename = (String) name.getValue();
                FileWriter myfile = new FileWriter("Main/res/skills/"+filename+".txt");
                myfile.write(skill_code1.getText()+" "+ skill_code2.getText()+" "+ skill_code3.getText()+" "+ user_skill_input.getText()+"\n");
                myfile.close();
                System.out.println("Successfully wrote to the file.");
                name.getItems().add(filename);
            } catch (IOException e) {
                System.out.println("An error occurred.");
            }
        });

        request.setPromptText("Load or Save Skills ...");
        request.setTranslateX(207);
        request.setTranslateY(500);
        request.setOnKeyPressed(ke -> {
            if (ke.getCode().equals(KeyCode.ENTER)) {
                System.out.println("You entered a request");
                String text = request.getText();
                processor.proceedUser(text, chat);
            }
        });
        you_entered_a_request.setOnKeyPressed(ke -> {
            if (ke.getCode().equals(KeyCode.ENTER)) {
                System.out.println("You entered a request");
                String text = you_entered_a_request.getText().toLowerCase();
                processor.proceedUser(text, chat);
                String answer = null;
                try {
                    answer = reader.matching(text);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                processor.proceedAssistant(answer, chat);
                if (text.contains("add activity :")){
                    appendActivity(text);
                    processor.proceedAssistant("Your activity was perfectly added to your coming activities", chat);
                }
            }
        });

        ask.setTranslateX(199);
        ask.setTranslateY(465);
        ask.setOnAction((event) -> {
            pane.getChildren().remove(ask);
            pane.getChildren().add(loadSkills);
            pane.getChildren().add(saveSkills);
            pane.getChildren().add(newSkill);
            pane.getChildren().add(request);
            pane.getChildren().add(chat);
            pane.getChildren().add(InputText);
            pane.getChildren().add(you_entered_a_request);

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

    public static void countArrow(String text, Group secondaryLayout, Button save, Label action, TextField a, TextField s1, TextField s2, TextField s3, Label namefile, ComboBox name) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '<' || text.charAt(i) == '>')
                count++;
        }
        if (count % 2 == 0) {
            count = count / 2;
        }

        Label slot1 = new Label("Slot1 : ");
        Label slot2 = new Label("Slot2 : ");
        Label slot3 = new Label("Slot3 : ");

        switch(count){
            case 1:
                slot1.setTranslateX(200);
                slot1.setTranslateY(100);
                s1.setTranslateX(250);
                s1.setTranslateY(100);
                action.setTranslateY(150);
                a.setTranslateY(150);
                name.setTranslateY(200);
                namefile.setTranslateY(205);
                save.setTranslateY(200);
                secondaryLayout.getChildren().addAll(slot1,s1,save,action,a,name,namefile);
                break;

            case 2:
                slot1.setTranslateX(200);
                slot1.setTranslateY(100);
                slot2.setTranslateX(200);
                slot2.setTranslateY(150);
                s1.setTranslateX(250);
                s1.setTranslateY(100);
                s2.setTranslateX(250);
                s2.setTranslateY(150);
                action.setTranslateY(200);
                a.setTranslateY(200);
                name.setTranslateY(250);
                namefile.setTranslateY(255);
                save.setTranslateY(250);
                secondaryLayout.getChildren().addAll(slot1,slot2,s1,s2,save,action,a,name,namefile);
                break;

            case 3:
                slot1.setTranslateX(200);
                slot1.setTranslateY(100);
                slot2.setTranslateX(200);
                slot2.setTranslateY(150);
                slot3.setTranslateX(200);
                slot3.setTranslateY(200);
                s1.setTranslateX(250);
                s1.setTranslateY(100);
                s2.setTranslateX(250);
                s2.setTranslateY(150);
                s3.setTranslateX(250);
                s3.setTranslateY(200);
                action.setTranslateY(250);
                a.setTranslateY(250);
                name.setTranslateY(300);
                namefile.setTranslateY(305);
                save.setTranslateY(300);
                secondaryLayout.getChildren().addAll(slot1,slot2,slot3,s1,s2,s3,save,action,a,name,namefile);
                break;
        }
    }
}
