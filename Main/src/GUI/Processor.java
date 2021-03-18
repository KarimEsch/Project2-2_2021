package GUI;

import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextArea;


import java.util.ArrayList;

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
}

