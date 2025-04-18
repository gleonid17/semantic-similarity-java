package hw4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class is a builder for the SemanticDescriptors class,
 * it is used solely to convert a list of text into a map of semantic
 * descriptors.
 * It extends the SemanticDescriptors class to provide a convenient way to
 * create instances of it.
 * 
 * * @author George Leonidou and Andreas Kristian Mylonas
 * * @since 17/04/2025
 * * @see SemanticDescriptors
 */
public class SemanticDescriptorBuilder extends SemanticDescriptors {

    /**
     * given a list of sentences, it creates a map of semantic descriptors.
     * each word in the sentence is a key in the map, and the value is another map
     * that contains the words that co-occur with the key word in the same sentence,
     * the return type is a final so the user can not alter it.
     * 
     * @param textArrayList the list of sentences to be converted into a map of
     *                      semantic descriptors
     * @return a SemanticDescriptors object containing the semantic relations
     *         between words
     */
    public static final SemanticDescriptors listToMap(ArrayList<ArrayList<String>> textArrayList) {
        if (textArrayList == null || textArrayList.isEmpty()) {
            return new SemanticDescriptors(new HashMap<>());
        }
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
        for (ArrayList<String> sentence : textArrayList) {
            for (String word : sentence) {
                if (!map.containsKey(word))
                    map.put(word, new HashMap<String, Integer>());
                calculateCoOccurance(map, sentence, word);
            }
        }
        return new SemanticDescriptors(map);
    }

    /**
     * this method calculates the co-occurrences of
     * a word in a sentence to every other word of that same
     * sentence and updates the map accordingly.
     * 
     * @param map      the map of semantic descriptors
     * @param sentence the sentence we are examining
     * @param word     the word we are examining
     */
    private static void calculateCoOccurance(HashMap<String, HashMap<String, Integer>> map, ArrayList<String> sentence,
            String word) {
        HashMap<String, Integer> subMap = map.get(word);
        for (String word2 : sentence) {
            if (word.equals(word2)) {
                continue;
            }
            if (subMap.containsKey(word2)) {
                Integer count = subMap.get(word2);
                subMap.put(word2, count + 1);
            } else { // if this is the first encounter between word and word2
                subMap.put(word2, 1);
            }
        }
    }
}
