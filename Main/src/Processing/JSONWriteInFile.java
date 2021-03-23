package Processing;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

/**
 * @author Karim Eschweiler
 * How to write JSON object to File in Java?
 */

/*
This class allows you to parse the user input and write into the JSON file.
 */
public class JSONWriteInFile {
    //private static FileWriter file;
    public static ArrayList linststring;

    public static void main(String[] args) {
        appendActivity("ee");

       /* // JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
        /*JSONObject skillsFeatures = new JSONObject();
        skillsFeatures.put("Name", "Skills");
        JSONObject skillsFeatures1 = new JSONObject();
        skillsFeatures1.put("Namee", "Skills");

        JSONArray days = new JSONArray();
        days.add("day: Monday");
        days.add("day: Tuesday");
        days.add("day: Wednesday");
        days.add("day: Thursday");
        days.add("day: Friday");
        days.add("day: Saturday");
        days.add("day: Sunday");
        skillsFeatures.put("day", days);

        JSONArray time = new JSONArray();
        time.add("time: 9");
        time.add("time: 11");
        time.add("time: 13");
        time.add("time: 15");
        skillsFeatures.put("day",time);

        try {

            // Constructs a FileWriter given a file name, using the platform's default charset
            file = new FileWriter("Main/res/testCurrentSkillsAdd");
            file.write(skillsFeatures.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + skillsFeatures);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }
    public static void appendActivity (String txt){
        System.out.println("");

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new
                    FileReader("Main/res/testCurrentSkillsAdd"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);
            linststring= new ArrayList();
            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("activities");

            Activities activity1 = new Activities();
            String [] daysOfTheWeek = new String[]{"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
            String [] timeSlots = new String[]{"9","11","13","15"};
            for (int i=0 ;i<6 ;i++){
                if (txt.toLowerCase().contains(daysOfTheWeek[i]))
                activity1.setDay(daysOfTheWeek[i]);
            }
            for (int i=0 ;i<4 ;i++){
                if (txt.toLowerCase().contains(timeSlots[i]))
                activity1.setTime(timeSlots[i]);
            }
            activity1.setAnswer("You have activity on "+activity1.getDay()+" at "+activity1.getTime());
            Gson gson = new Gson();
            String json = gson.toJson(activity1);
            System.out.println("json---->" + json);



            FileWriter file = new FileWriter("Main/res/testCurrentSkillsAdd", false);
            JsonWriter jw = new JsonWriter(file);
            Iterator iterator = msg.iterator();
            Activitiess activities = new Activitiess();
            while (iterator.hasNext()) {
                activities.addActivity(gson.fromJson(iterator.next().toString(), Activities.class));
            }
            activities.addActivity(activity1);
            gson.toJson(activities, Activitiess.class, jw);
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}