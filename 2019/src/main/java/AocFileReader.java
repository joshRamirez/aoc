import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AocFileReader {
    public static List<String> readFile(String fileName) {
        List<String> results = new ArrayList();
        File file = new File(fileName);
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(file));
            String result;
            while ((result = br.readLine()) != null) {
                results.add(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return results;
    }
}
