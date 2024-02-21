package Infrastructure.Utils.Json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;


public class JsonReader {

    public static String getValue(String keyName) throws Exception  {
        Object obj = new JSONParser().parse(new FileReader("src/main/resources/Configuration.json"));
        JSONObject jo = (JSONObject) obj;

        return jo.get(keyName).toString();
    }


}