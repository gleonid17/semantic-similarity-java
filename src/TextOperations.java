/**
 * This interface defines the operations for text processing,
 * including converting text to a list of sentences and getting the number of sentences.
 * 
 * @author George Leonidou and Andreas Kristian Mylonas    
 * @since 13/04/2025
 */

import java.util.ArrayList;

public interface TextOperations {

    /**
     * Converts the text to a list of sentences, where each sentence is represented
     * as a list of words.
     * 
     * @return The ArrayList of ArrayLists containing the words of each sentence of
     *         the text.
     */
    public ArrayList<ArrayList<String>> convertTextToList();

    /**
     * Converts the text from the specified files to a list of sentences,
     * where each sentence is represented as a list of words.
     * 
     * @param fileNames An ArrayList of file names to be processed.
     * @return An ArrayList of ArrayLists containing the words of each sentence of
     *         the text.
     */
    public ArrayList<ArrayList<String>> getListFromFiles(ArrayList<String> fileNames);
}