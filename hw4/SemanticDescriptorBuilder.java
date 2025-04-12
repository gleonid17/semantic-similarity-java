package hw4;

import java.util.ArrayList;
import java.util.HashMap;

public class SemanticDescriptorBuilder extends SemanticDescriptors{

    public SemanticDescriptorBuilder(HashMap<String, HashMap<String, Integer>> map) {
        super(map);
    }   

    public final HashMap<String, HashMap<String, Integer>> listToMap(ArrayList<ArrayList<String>> listOfLists) {
     HashMap<String, HashMap<String, Integer>> map = null;
     /**
     * code
     */
   
    return  (new SemanticDescriptorBuilder(map)).getMap();
    }
}
