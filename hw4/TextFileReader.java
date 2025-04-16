package hw4;

/**
 * This class is responsible for reading a text file and returning its content as a string.
 * It handles any IO exceptions that may occur during the file reading process.
 * 
 * @author George Leonidou and Andreas Kristian Mylonas    
 * @version 1.0 
 * @since 13/04/2025
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {
    private String filename;

    public TextFileReader(String filename) {
        this.filename = filename;
    }

    public String readFile() {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line);
            }
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
        return contentBuilder.toString();   
    }
}
