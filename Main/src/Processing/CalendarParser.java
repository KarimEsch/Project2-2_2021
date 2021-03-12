
//It is not working at all for the moment I was working on that before maybe we will adapt it to work with our assistant phase 2.
package Processing;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class CalendarParser {
    private StringBuilder content;
    public CalendarParser(){

    }

    public String getUrlContents(String calendarURL)
    {

        // many of these calls can throw exceptions, so i've just
        // wrapped them all in one try/catch statement.
        try
        {
            // create a url object
            URL url = new URL(calendarURL);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                this.content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }
}
