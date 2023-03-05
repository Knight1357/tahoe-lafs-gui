import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class HashMapToJsonFileExample {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "John");
        map.put("age", 30);
        map.put("city", "New York");

        // Convert HashMap to JSON and write to file
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter("data.json");
            gson.toJson(map, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
