package GUI;

import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import txtFile.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Processor {

    TextProcessor process = new TextProcessor();
    public Processor(){

    }
    public void proceed(String text, TextArea area) {
        System.out.println("proceeding");
        //area.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        area.appendText("\n>" + "USER :- "  + text);
    }
     public void digitalproceed(String text, TextArea area) throws FileNotFoundException {
         System.out.println(" Digital assistant proceeding");
         //area.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
         area.appendText("\n>" + "ASSISTANT :- "  + process.LectureFinder(text));
     }


}

