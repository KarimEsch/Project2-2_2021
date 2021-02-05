package GUI;

import javafx.scene.control.ChoiceBox;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Skills {
    ChoiceBox savedSkills = new ChoiceBox();
    private ArrayList<String> arrayOfSkills = new ArrayList<>();

    public Skills(){

    }
    public void displaySkills(){

    }
    public void readCurrentSkills(){
        try {
            File myObj = new File("Main/res/currentSkills.csv");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                arrayOfSkills.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void writeSkill(String inputSkill){
        try {
            FileWriter myWriter = new FileWriter("Main/res/currentSkills.csv",true);
            myWriter.write("\n"+inputSkill);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public boolean matchSkills(){
        readCurrentSkills();
        return true;
    }
    public ArrayList<String> getCurrentSkills(){
        return arrayOfSkills;
    }
}
