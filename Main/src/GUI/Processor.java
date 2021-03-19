package GUI;

import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextArea;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Processor {
    public Processor(){

    }
    public void proceedUser(String text, TextArea area){
        System.out.println("proceeding");
        //area.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        area.appendText("\n>" + "USER :- "  + text +"\n");
    }
     public void proceedAssistant(String text, TextArea area){
         System.out.println(" Digital assistant proceeding");
         //area.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
         area.appendText("\n>" + "ASSISTANT :- "  + text +"\n");
     }
    public TextArea readFromFileIntoTextArea(String fileName){
        TextArea textArea = new TextArea();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                textArea.appendText(data+"\n");
            }
            myReader.close();
            return textArea;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
}

