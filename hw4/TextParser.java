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

    /**
     * Constructor for the TextParser class,
     * initializes the text to be parsed and sets the number of sentences to 0.
     * 
     * @param text The text to be parsed.
     */
    public TextParser(String text) {
        this.text = text.toLowerCase();
    }
    
    public TextParser(){
        this("");
    }

    /**
     * This method converts the text into a list of sentences,
     * where each sentence is further tokenized into words.
     * 
     * @return An ArrayList of ArrayLists, where each inner ArrayList contains the words of a sentence.
     */
    @Override
    public ArrayList<ArrayList<String>> convertTextToList() {
        ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
        StringTokenizer tokenizer = new StringTokenizer(this.text, ".?!"); 
        ArrayList<String> sentences = tokenizerToList(tokenizer);
        for (int i = 0; i < sentences.size(); i++) {
            StringTokenizer tempTokenizer = new StringTokenizer(sentences.get(i), " ,.-:\";'");
            listOfLists.add(tokenizerToList(tempTokenizer));
        }
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
        ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < fileNames.size(); i++) {
            TextParser tempParser = new TextParser(TextFileParser.readFile(fileNames.get(i)));
            if (tempParser.text == null)
                continue; // Skip if the file could not be read
            ArrayList<ArrayList<String>> list = tempParser.convertTextToList();
            listOfLists.addAll(list);
        }
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
    private ArrayList<String> tokenizerToList(StringTokenizer tokenizer){
        ArrayList<String> list = new ArrayList<String>(tokenizer.countTokens());
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken().toString().trim());
        }
        return list;       
    }

    
}