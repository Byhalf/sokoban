/**
 * File Parser permet de lire un fichier et de convertir son contenu en String
 */

package utulities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
    /**
     * parse lit un fichier et converti en String son contenu
     * @param filePath le chemin du fichier à lire
     * @return le contenu du fichier en String
     * @throws Exception
     */
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
