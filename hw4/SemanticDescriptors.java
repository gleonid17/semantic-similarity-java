package hw4;

import java.util.*;

/**
 * This class is a model for semantic descriptors, 
 * it extends the HashMap class so one can call the methods of HashMap
 * directly through a SemanticDescriptors object along with adding new methods.
 * It is used to store the semantic relations between words in a text.
 * 
 * 
 * @author George Leonidou and Andreas Kristian Mylonas
 * @since 17/04/2025
 * @see HashMap
 */
public class SemanticDescriptors extends HashMap {
    private HashMap<String, HashMap<String, Integer>> map;

    /**
     * Constructs a SemanticDescriptors object with a given HashMap,
     * This constructor is protected to ensure that the class is not instantiated directly
     * but only through a builder subclass.
     * 
     * @param map The HashMap containing the semantic relations between words.
     */
    protected SemanticDescriptors(HashMap<String, HashMap<String, Integer>> map) {
        this.map = map;
    }

    protected SemanticDescriptors() {
        this.map = null;
    }

    /**
     * Returns the amount of times word1 and word2 co-occur in the same sentence.
     * @param word1 the first word
     * @param word2 the second word
     * @return the number of times word1 and word2 co-occur in the same sentence
     */
    public Integer getRelationOccurance(String word1, String word2) {
        if (map.containsKey(word1) && map.get(word1).containsKey(word2)) {
            return map.get(word1).get(word2);
        }
        return 0;
    }

    //add more methods if needed

}
