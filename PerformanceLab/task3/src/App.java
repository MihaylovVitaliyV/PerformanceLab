import com.google.gson.*;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class App {
    public static void main(String[] args) throws Exception {

        Gson gson = new Gson();

        Data testsData = gson.fromJson(new FileReader("src\\tests.json"),
                Data.class);
        Data valuesData = gson.fromJson(new FileReader("src\\values.json"),
                Data.class);

        for (int i = 0; i <= valuesData.values.length - 1; i++) {
            if (testsData.id == valuesData.values[i].id) {
                testsData.value = valuesData.values[i].value;
            } else {
                for (int j = 0; j <= testsData.values.length - 1; j++) {
                    if (testsData.values[j].id == valuesData.values[i].id) {
                        testsData.values[j].value = valuesData.values[i].value;
                    }
                }
            }
        }

        String json = gson.toJson(testsData);
        BufferedWriter writer = new BufferedWriter(new FileWriter("src\\report.json"));
        writer.write(json);
        writer.close();
    }

    public class Data {
        private int id;
        private String title;
        private String value;
        private Values[] values;
    }

    public class Values {
        private int id;
        private String title;
        private String value;
    }
}