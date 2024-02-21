package Infrastructure.Utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;



public class JsonReader {

    /**
     * The type Json reader that parses selected value
     * from the main/resources/Configuration.json file
     * @param keyName - name of the value from json file
     * @return String - return parsed value
     */
    public static String getValue(String keyName){
        Object obj = null;
        try {
            obj = new JSONParser().parse(new FileReader("src/main/resources/Configuration.json"));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        JSONObject jo = (JSONObject) obj;

        return jo.get(keyName).toString();
    }


}