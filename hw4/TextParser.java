package hw4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TextParser implements TextOperations{
    private String text;

    public TextParser(String text) {
        this.text = text;
    }       

    private ArrayList<String> tokenizerToList(String delim){
        StringTokenizer tokenizer = new StringTokenizer(this.text,delim);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < tokenizer.countTokens(); i++) {
            list.add(tokenizer.nextToken().toString().trim());
        }
        return list;       
    }

    @Override
    public ArrayList<ArrayList<String>> getTextAsList(String text) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        
    }

    @Override
    public ArrayList<ArrayList<String>> getListFromFiles(ArrayList<String> fileNames) {
        /**
         * code
         */
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        return list;
    }
}