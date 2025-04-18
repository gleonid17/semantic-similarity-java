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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {
    private String filename;

    /**
     * Constructor for the TextFileReader class
     * Initializes the filename to be read.
     * @param filename
     */
    public TextFileReader(String filename) {
        this.filename = filename;
    }

    /**
     * Reads the content of the file specified by the filename.
     * It uses a BufferedReader to read the file line by line and appends each line to a StringBuilder.
     * @return The content of the file as a string, or null if an error occurs. 
     */
    public String readFile() {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filename))) {
            String line = reader.readLine();
            while (line != null) {
                contentBuilder.append(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found or could not be opened.");
            return null;
        } catch (IOException e) {
            System.out.println("Error reading file.");
            return null;
        }
        return contentBuilder.toString();   
    }
}
