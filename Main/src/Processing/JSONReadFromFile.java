package Processing;
import java.io.FileNotFoundException;
        import java.io.FileReader;
        import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
        import org.json.simple.JSONObject;
        import org.json.simple.parser.JSONParser;
        import org.json.simple.parser.ParseException;

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

            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
            JSONObject jsonObject = (JSONObject) obj;

            // A JSON array. JSONObject supports java.util.List interface.
            JSONArray companyList = (JSONArray) jsonObject.get("DAYS");

            // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
            // Iterators differ from enumerations in two ways:
            // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
            // 2. Method names have been improved.
            Iterator<JSONObject> iterator = companyList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}