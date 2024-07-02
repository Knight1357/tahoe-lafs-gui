package HttpTest;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// 下载二进制文件
public class BinaryFileViewTest {
    public static void main(String[] args) throws Exception {


        String urlString = "http://47.115.222.245:3456/uri/URI%3ACHK%3Axd3cxxdh4jk6ys5mhfzox6mdgy%3Amauyymc77s3cwdexcx5a2awpiji4bp5dwv6t4l4b4jouavqgfb4a%3A3%3A10%3A655074";

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "image/png");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = connection.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            FileOutputStream fileOutputStream = new FileOutputStream("data/download/sample.png");
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bufferedInputStream.read(buffer, 0, 1024)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            fileOutputStream.close();
            bufferedInputStream.close();
            inputStream.close();
            System.out.println("文件下载完成！");
        } else {
            System.out.println("HTTP请求失败，错误码为：" + responseCode);
        }
    }
}
