package CMDTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CMD {
    public static String PATH="C:\\Users\\48444\\OneDrive\\works\\tahoe-lafs-tahoe-lafs-1.12.1\\venv\\Scripts\\tahoe.exe ";
    public static void main(String[] args) {
        System.out.println(PATH);
        StringBuilder stringBuilder = new StringBuilder();
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(PATH +"--help");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream(), "GBK"));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            System.out.println(stringBuilder);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }
}
