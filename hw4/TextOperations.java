package hw4;

import java.util.ArrayList;

public interface TextOperations {
    public ArrayList<ArrayList<String>> getTextAsList(String text);

    public ArrayList<ArrayList<String>> getListFromFiles(ArrayList<String> fileNames);
}
