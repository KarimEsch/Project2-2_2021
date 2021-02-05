package GUI;

import javafx.scene.control.TextArea;

public class Processor {
    public Processor(){

    }
    public void proceed(String text, TextArea area){
        System.out.println("proceeding");
        area.appendText("\n>"+text);
    }
}
