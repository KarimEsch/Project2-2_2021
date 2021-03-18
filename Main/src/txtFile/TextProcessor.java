package txtFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextProcessor {

    public String file;

    public ArrayList<String> findData(String text){
        String[] splitSentence = text.split(" ");
        file = splitSentence[0].substring(0, splitSentence[0].length() - 1);
        ArrayList<String> data = new ArrayList<>();
        for(int i = 0; i < splitSentence.length; i++){
            if(splitSentence[i].startsWith("<")){
                data.add(splitSentence[i].substring(1, splitSentence[i].indexOf(">")));
            }
        }
        return data;
    }

    public String LectureFinder(String input) throws FileNotFoundException {

        String returnString = " ";
        ArrayList<String> data = this.findData(input);

        File planning = new File("C:\\Users\\teunh\\Project2-2_2021\\Main\\res\\skills\\"+file+".txt");
        Scanner reader = new Scanner(planning);


        while (reader.hasNextLine()){
            String[] sentence = reader.nextLine().split(" ");
            if(data.get(0).toLowerCase().equalsIgnoreCase(sentence[0]) && data.get(1).equalsIgnoreCase(sentence[1])){
                for(int i = 2; i < sentence.length; i++){
                    returnString = returnString.concat(sentence[i] + " ");
                    System.out.println(returnString);
                }
            }
        }

        if (returnString.equals(" ")){
            returnString = "I could not find the lecture at this moment, try any of these timeslots: 09:00, 11:00, 13:00";
        }

        return returnString;
    }


}
