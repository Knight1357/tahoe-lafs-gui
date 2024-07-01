package PrintTest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class PrintUri {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String hashVal="URI:SSK:i7p4iidbnlkvwuwcqptjbwguqa:5w27doa5r7gk7x7ruqdeegxb5izu2atxf6ympunydoexs6hzls3q";
        System.out.println(hashVal);

        System.out.println(URLEncoder.encode(hashVal, "UTF-8"));
    }
}
