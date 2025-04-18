package hw4;

/**
 * This class is a Calculator for all the equations that are needed to Calculate the similarity between two vectors. 
 * 
 * @author George Leonidou and Andreas Kristian Mylonas
 * @version 1.0
 * @since 13/04/2025
 */

import java.util.HashMap;

public abstract class SimilarityCalculator {
    /**
     * Calculates the cosine similarity between two vectors.
     * 
     * @param vec1 The first vector.
     * @param vec2 The second vector.
     * @return double number between 0 and 1 representing cosine similarity between the two vectors,
     * returns -1 if similarity could not be calculated.
     */
    public static double cosineSimilarity(HashMap<String, Integer> vec1, HashMap<String, Integer> vec2) {
        if (vec1 == null || vec2 == null) {
            return -1;
        }
        if (vec1.isEmpty() || vec2.isEmpty()) {
            return -1;
        }
        double dotPoroduct = 0;
        double denominator = (calculateNorm(vec1) * calculateNorm(vec2));
        if (denominator == 0) {
            return -1;
        }
        try {
            for (String key : vec1.keySet()) {
                if (vec2.containsKey(key)) {
                    dotPoroduct += vec1.get(key) * vec2.get(key);
                }
            }
            return dotPoroduct / denominator;
        } catch (Exception e) {
            return -1;
        }
    }
    
    /**
     * Calculates the norm of a vector.
     * @param vec The vector to calculate the norm for.
     * @return The norm of the vector.
     */
    private static double calculateNorm(HashMap<String, Integer> vec) {
        double norm = 0;
        for (String key : vec.keySet()) {
            norm += Math.pow(vec.get(key), 2);
        }
        return Math.sqrt(norm);
    }
}
