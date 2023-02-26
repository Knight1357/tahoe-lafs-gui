package JsonTransformTest;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class JsonTransform {

    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("/Users/liushen/Library/CloudStorage/OneDrive-个人/works/Tahoe-Lafs-GUI/Tahoe-Lafs-GUI/src/test/JsonTransformTest/Test.json")) {

            // Convert JSON File to Java Object
            Test test = gson.fromJson(reader, Test.class);

            System.out.println(test);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Test{
    Site[] sites;

    @Override
    public String toString() {
        return "Test{" +
                "sites=" + Arrays.toString(sites) +
                '}';
    }
}

class Site{
    String name;
    String uri;
    Student student;

    @Override
    public String toString() {
        return "site{" +
                "name='" + name + '\'' +
                ", uri='" + uri + '\'' +
                ", student=" + student +
                '}';
    }
}

class Student{
    String name;
    int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

