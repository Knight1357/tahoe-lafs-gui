import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class JsonToHashMapExample {
    public static void main(String[] args) throws IOException {

        FileReader reader = new FileReader("data.json");
        Gson gson = new Gson();
        HashMap<String, Object> map = gson.fromJson(reader, HashMap.class);
        reader.close();

        System.out.println(map);
    }
}
