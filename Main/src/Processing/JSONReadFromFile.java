package Processing;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Karim Eschweiler
 * This class allows you to parse information from "activity.json" JSON file to see if there is any matching with
 * user input and json activities.
 */

public class JSONReadFromFile
{
    private final String file;

    public JSONReadFromFile(String file)
    {
        this.file = file;
    }
    @SuppressWarnings("unchecked")
    public String parseSkills(){
        //JSONParser parser = new JSONParser();
        try {
           // Object obj = parser.parse(new FileReader("currentActivities"));

            //ArrayList elements = new ArrayList();

            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
           // JSONObject jsonObject = (JSONObject) obj;

            // A JSON array. JSONObject supports java.util.List interface.
            //JSONArray activities = (JSONArray) jsonObject.get("activities");


            // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
            // Iterators differ from enumerations in two ways:
            // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
            // 2. Method names have been improved.
            /*for(int i=0;i<3;i++){
                Iterator<JSONObject> iterator = activities.iterator();
                JSONObject jsonObject1 = (JSONObject) obj;
                while (iterator.hasNext()) {
                    elements.add(iterator);
                    System.out.println(iterator.next());
                }
            }
            System.out.println(elements.size() );*/
            String json= new String(Files.readAllBytes(Paths.get("currentActivities")));
            JSONParser parser = new JSONParser();
            ArrayList<Activities> allActitivities =  new ArrayList<Activities> ();
            try {
                /* It's a JSONArray first. */
                JSONArray tmpArr = (JSONArray)parser.parse(json);
                for(Object obj : tmpArr){
                    /* Extract each JSONObject */
                    JSONObject tmpObj = (JSONObject) obj;
                    //System.out.println("time = " + tmpObj.get("time"));
                    //System.out.println("day = " + tmpObj.get("day"));
                    //System.out.println("answer = " + tmpObj.get("answer"));
                    //System.out.println(tmpObj.get("date_manufactured"));
                    Activities activity = new Activities(tmpObj.get("time").toString(),tmpObj.get("day").toString(),tmpObj.get("answer").toString());
                    allActitivities.add(activity);
                }
                //System.out.println(Arrays.toString(allActitivities.get(0).getActivity()));
                return allActitivities.get(0).getActivity()[2];
            } catch (ParseException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public String matching(String txt) throws IOException {
        String txtLowerCase = txt.toLowerCase();
        String json= new String(Files.readAllBytes(Paths.get("currentActivities")));
        JSONParser parser = new JSONParser();
        try {
            /* It's a JSONArray first. */
            JSONArray tmpArr = (JSONArray)parser.parse(json);
            for(Object obj : tmpArr){
                /* Extract each JSONObject */
                JSONObject tmpObj = (JSONObject) obj;
                System.out.println(tmpObj.get("day").toString()+" at " + tmpObj.get("time").toString());
                if(txtLowerCase.contains(tmpObj.get("day").toString()+" at " + tmpObj.get("time").toString())){
                    Activities activity = new Activities(tmpObj.get("time").toString(),tmpObj.get("day").toString(),tmpObj.get("answer").toString());
                    return activity.getAnswer();
                }
            }
            return "Sorry, but no skills known so far to evaluate your request";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }
}