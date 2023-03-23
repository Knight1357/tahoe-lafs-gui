package HttpTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SendCreateDirTest {
    public static void main(String[] args) throws Exception {
//http://47.115.222.245:3456/uri/URI%3ADIR2%3Awti64bj6ovkrubpngomrldezpi%3Ai7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka?t=mkdir-immutable&name=666nb
//URI:DIR2:wti64bj6ovkrubpngomrldezpi:i7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka

        String fileName="n62s66";
        String hashVal="URI:DIR2:wti64bj6ovkrubpngomrldezpi:i7xev2c7bgrsu4remvipyeqzsb2qbrcbgteywvcijx5qetbc4pka";
        String urlString = "http://47.115.222.245:3456/uri/"+ URLEncoder.encode(hashVal,"UTF-8")+"?t=mkdir&name="+URLEncoder.encode(fileName,"UTF-8");
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
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
