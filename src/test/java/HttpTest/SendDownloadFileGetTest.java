package HttpTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class SendDownloadFileGetTest {
    public static void main(String[] args) throws Exception {

        String hashVal2 = "URI:SSK:3qylezfxtxvoifdfreayse556u:yvlag2qazwtukwdu7afwvzmbo3k7bqlk4bg4q25btj6jjvklgrmq";

        String fileName = "hello.xlsx";
        String save = "true";
        String urlString = "http://47.115.222.245:3456/uri?uri=" + URLEncoder.encode(hashVal2, StandardCharsets.UTF_8) +
                "&filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8) +
                "&save=" + URLEncoder.encode(save, StandardCharsets.UTF_8);

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
            System.out.println(response);
        } else {
            System.out.println("HTTP请求失败，错误码为：" + responseCode);
        }
    }
}
