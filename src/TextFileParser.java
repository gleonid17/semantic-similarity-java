import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class is responsible for reading a text file and returning its content
 * as a string.
 * It handles any IO exceptions that may occur during the file reading process.
 * 
 * @author George Leonidou and Andreas Kristian Mylonas
 * @since 13/04/2025
 */

public class TextFileParser extends TextParser {

    public static String readFile(String fileName) {
        StringBuilder contentBuilder = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                contentBuilder.append(line);
                contentBuilder.append("\n");
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found or could not be opened.");
            return null;
        } catch (IOException e) {
            System.out.println("Error reading file.");
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error closing file.");
                }
            }
        }
        return contentBuilder.toString();
    }
}
