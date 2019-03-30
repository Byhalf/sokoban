package utulities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
    public static String parse(String filePath) throws Exception {
        String line = null;
        String res = "";
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(filePath);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                res += line + "\n";
            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            filePath + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + filePath + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return res;
    }
}
