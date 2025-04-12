package hw4;

import java.util.HashMap;

public class SemanticDescriptors {
    private HashMap<String, HashMap<String, Integer>> map;

    protected SemanticDescriptors(HashMap<String, HashMap<String, Integer>> map) {
        this.map = map;
    }

    public final HashMap<String, HashMap<String, Integer>> getMap(){
        return this.map;
    }

    /**
     * Hashmap read methods
     */
}
