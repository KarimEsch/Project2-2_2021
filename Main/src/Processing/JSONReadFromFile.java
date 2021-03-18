package Processing;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONReadFromFile
{
    private final String file;

    public JSONReadFromFile(String file)
    {
        this.file = file;
    }
    @SuppressWarnings("unchecked")
    public void parseSkills(){
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(this.file));

            ArrayList elements = new ArrayList();

            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
            JSONObject jsonObject = (JSONObject) obj;

            // A JSON array. JSONObject supports java.util.List interface.
            JSONArray activities = (JSONArray) jsonObject.get("activities");


            // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
            // Iterators differ from enumerations in two ways:
            // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
            // 2. Method names have been improved.
            for(int i=0;i<3;i++){
                Iterator<JSONObject> iterator = activities.iterator();
                JSONObject jsonObject1 = (JSONObject) obj;
                while (iterator.hasNext()) {
                    elements.add(iterator);
                    System.out.println(iterator.next());
                }
            }
            System.out.println(elements.size() );
            System.out.println(elements.get(1) );
            System.out.println(elements.get(2) );
            System.out.println(elements.get(3) );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}