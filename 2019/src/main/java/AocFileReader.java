import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AocFileReader {

    /**
     * reads a file where there is 1 independent data point per line
     *
     * @param fileName name of the file to be used
     * @return list of values
     */
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

    /**
     * reads a file where all the data points are in a single line and are comma separated values
     *
     * @param fileName name of the file to be used
     * @return list of values
     */
    public static List<String> readList(String fileName) {
        List<String> results = new ArrayList();
        File file = new File(fileName);
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(file));
            String result = br.readLine();
            if (result != null) {
                String[] data = result.split(",");
                results = Arrays.asList(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return results;
    }
}
