package hw4;

import java.util.ArrayList;

public interface TextOperations {
    public ArrayList<ArrayList<String>> convertTextToList();

    public ArrayList<ArrayList<String>> getListFromFiles(ArrayList<String> fileNames);

    public int getNumberOfSentences();
}