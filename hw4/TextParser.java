package hw4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TextParser implements TextOperations{
    private String text;
    private int numberOfSentences;

    public TextParser(String text) {
        this.text = text;
        this.numberOfSentences = 0;
    }       

    private ArrayList<String> tokenizerToList(String text, String delim){
        text = text.toLowerCase();
        StringTokenizer tokenizer = new StringTokenizer(text,delim);
        ArrayList<String> list = new ArrayList<>(tokenizer.countTokens());
        for (int i = 0; i < tokenizer.countTokens(); i++) {
            list.add(tokenizer.nextToken().toString().trim());
        }
        return list;       
    }

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

    @Override
    public ArrayList<ArrayList<String>> getListFromFiles(ArrayList<String> fileNames) {
        ArrayList<ArrayList<String>> listOfLists = new ArrayList<>();
        for (int i = 0; i < fileNames.size(); i++) {
            TextParser textParser = new TextParser(readFile(fileNames.get(i)));
            ArrayList<ArrayList<String>> list = textParser.convertTextToList();
            for (int j = 0; j < textParser.getNumberOfSentences(); j++) {
                listOfLists.add(list.get(j));
            }
        }
        this.numberOfSentences = listOfLists.size();   
        return listOfLists;
    }

    public int getNumberOfSentences() {
        return this.numberOfSentences;
    }

    private static String readFile(String filename) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
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