package Processing;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Crunchify.com
 * How to write JSON object to File in Java?
 */

class JSONWriteInFile {
    private static FileWriter file;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
        JSONObject skillsFeatures = new JSONObject();
        skillsFeatures.put("Name", "Skills");

        JSONArray days = new JSONArray();
        days.add("DAY: Monday");
        days.add("DAY: Tuesday");
        days.add("DAY: Wednesday");
        days.add("DAY: Thursday");
        days.add("DAY: Friday");
        days.add("DAY: Saturday");
        days.add("DAY: Sunday");
        skillsFeatures.put("DAYS", days);

        JSONArray time = new JSONArray();
        time.add("TIME: 9");
        time.add("TIME: 11");
        time.add("TIME: 13");
        time.add("TIME: 15");
        skillsFeatures.put("TIMES",time);

        try {

            // Constructs a FileWriter given a file name, using the platform's default charset
            file = new FileWriter("skills.json");
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
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}