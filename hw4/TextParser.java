package hw4;
/**
 * This class is a Parser for the text. 
 * It implements the TextOperations interface and provides methods to convert text to a list of sentences and words.
 * 
 * @author George Leonidou and Andreas Christian Mylonas    
 * @version 1.0 
 * @since 13/04/2025
 */

import java.util.ArrayList;
import java.util.StringTokenizer;

public class TextParser implements TextOperations{
    private String text;
    private int numberOfSentences;

    /**
     * Constructor for the TextParser class.
     * It initializes the text to be parsed and sets the number of sentences to 0.
     * @param text The text to be parsed.
     */
    public TextParser(String text) {
        this.text = text;
        this.numberOfSentences = 0;
    }       

    /**
     * This method takes a string and a delimiter, splits the string into tokens based on the delimiter and stores them in an ArrayList.
     * @param text The string to be tokenized.
     * @param delim The delimiter used to split the string.
     * @return An ArrayList of tokens.
     */
    private ArrayList<String> tokenizerToList(String text, String delim){
        text = text.toLowerCase();
        StringTokenizer tokenizer = new StringTokenizer(text,delim);
        ArrayList<String> list = new ArrayList<>(tokenizer.countTokens());
        for (int i = 0; i < tokenizer.countTokens(); i++) {
            list.add(tokenizer.nextToken().toString().trim());
        }
        return list;       
    }

    /**
     * This method converts the text into a list of sentences, where each sentence is further tokenized into words.
     * @return An ArrayList of ArrayLists, where each inner ArrayList contains the words of a sentence.
     */
    @Override
    public ArrayList<ArrayList<String>> convertTextToList() {
        ArrayList<ArrayList<String>> listOfLists = new ArrayList<>();
        ArrayList<String> sentenses = tokenizerToList(this.text,".?!");
        for (int i = 0; i < sentenses.size(); i++) {
            listOfLists.add(tokenizerToList(sentenses.get(i), " ,.-:\";'"));
        }
        this.numberOfSentences = sentenses.size();
        return listOfLists;
    }

    /**
     * This method processes a list of file names, reads the content of each file, and converts the text into a list of sentences.
     * @param fileNames An ArrayList of file names to be processed.
     * @return An ArrayList of ArrayLists, where each inner ArrayList contains the words of a sentence.
     */
    @Override
    public ArrayList<ArrayList<String>> getListFromFiles(ArrayList<String> fileNames) {
        ArrayList<ArrayList<String>> listOfLists = new ArrayList<>();
        for (int i = 0; i < fileNames.size(); i++) {
            TextParser textParser = new TextParser(new TextFileReader(fileNames.get(i)).readFile());
            ArrayList<ArrayList<String>> list = textParser.convertTextToList();
            for (int j = 0; j < textParser.getNumberOfSentences(); j++) {
                listOfLists.add(list.get(j));
            }
        }
        this.numberOfSentences = listOfLists.size();   
        return listOfLists;
    }

    /**
     * This method returns the number of sentences in the text.
     * @return The number of sentences in the text.
     */
    public int getNumberOfSentences() {
        return this.numberOfSentences;
    }
}