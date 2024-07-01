package HttpTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SendDownloadFileGetTest {
    public static void main(String[] args) throws Exception {
//URI%3ASSK%3Ai7p4iidbnlkvwuwcqptjbwguqa%3A5w27doa5r7gk7x7ruqdeegxb5izu2atxf6ympunydoexs6hzls3q
//URI:SSK:i7p4iidbnlkvwuwcqptjbwguqa:5w27doa5r7gk7x7ruqdeegxb5izu2atxf6ympunydoexs6hzls3q

        String hashVal2="URI:SSK:3qylezfxtxvoifdfreayse556u:yvlag2qazwtukwdu7afwvzmbo3k7bqlk4bg4q25btj6jjvklgrmq";

        String fileName="hello.xlsx";
        String save="true";
        String hashVal="URI:SSK:i7p4iidbnlkvwuwcqptjbwguqa:5w27doa5r7gk7x7ruqdeegxb5izu2atxf6ympunydoexs6hzls3q";
        String urlString = "http://47.115.222.245:3456/uri?uri="+ URLEncoder.encode(hashVal2,"UTF-8")+
                "&filename="+URLEncoder.encode(fileName,"UTF-8")+
                "&save="+URLEncoder.encode(save,"UTF-8");

//        String urlString="http://47.115.222.245:3456/uri?uri=URI%3ASSK%3Ai7p4iidbnlkvwuwcqptjbwguqa%3A5w27doa5r7gk7x7ruqdeegxb5izu2atxf6ympunydoexs6hzls3q&filename=hello.txt&save=true";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } else {
            System.out.println("HTTP请求失败，错误码为：" + responseCode);
        }
    }
}
