package hw4;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * This class is a Parser for the text. 
 * It implements the TextOperations interface and provides methods to convert text to a list of sentences and words.
 * 
 * @author George Leonidou and Andreas Kristian Mylonas    
 * @version 1.0 
 * @since 13/04/2025
 */
public class TextParser implements TextOperations{
    private final String text;
    private int numberOfSentences;

    /**
     * Constructor for the TextParser class,
     * initializes the text to be parsed and sets the number of sentences to 0.
     * 
     * @param text The text to be parsed.
     */
    public TextParser(String text) {
        this.text = text;
        this.numberOfSentences = 0;
    }       

    

    /**
     * This method converts the text into a list of sentences,
     * where each sentence is further tokenized into words.
     * 
     * @return An ArrayList of ArrayLists, where each inner ArrayList contains the words of a sentence.
     */
    @Override
    public ArrayList<ArrayList<String>> convertTextToList() {
        ArrayList<ArrayList<String>> listOfLists = new ArrayList<>();
        ArrayList<String> sentences = tokenizerToList(this.text,".?!");
        for (int i = 0; i < sentences.size(); i++) {
            listOfLists.add(tokenizerToList(sentences.get(i), " ,.-:\";'"));
        }
        this.numberOfSentences = sentences.size();
        return listOfLists;
    }

    /**
     * This method processes a list of file names,
     * reads the content of each file, and converts the text into a list of sentences.
     * 
     * @param fileNames An ArrayList of file names to be processed.
     * @return An ArrayList of ArrayLists, where each inner ArrayList contains the words of a sentence.
     */
    @Override
    public ArrayList<ArrayList<String>> getListFromFiles(ArrayList<String> fileNames) { 
        /*
         * i think this method should be rewritten to reuse the convertTextToList method.
         */
        ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < fileNames.size(); i++) {
            /*
             * i suggest textParser be named to "parse" for simplicity and clarity.
             */
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
     * This method takes a string and a delimiter,
     * splits the string into tokens based on the delimiter and stores them in an ArrayList.
     * 
     * @param text The string to be tokenized.
     * @param delim The delimiter used to split the string.
     * @return An ArrayList of String tokens.
     */
    private ArrayList<String> tokenizerToList(String text, String delim){
        text = text.toLowerCase();
        StringTokenizer tokenizer = new StringTokenizer(text,delim);
        ArrayList<String> list = new ArrayList<String>(tokenizer.countTokens());
        for (int i = 0; i < tokenizer.countTokens(); i++) {
            list.add(tokenizer.nextToken().toString().trim());
        }
        /*
         * while (tokenizer.hasMoreTokens()) {
         *     list.add(tokenizer.nextToken().toString().trim());
         * }
         * 
         * dear collegue i suggest the commented code, since the integer
         * 'i' is not used anywhere else in the branch.
         */
        return list;       
    }

    /**
     * This method returns the number of sentences in the text.
     * 
     * @return The number of sentences in the text.
     */
    public Integer getNumberOfSentences() {
        return this.numberOfSentences;
    }
}