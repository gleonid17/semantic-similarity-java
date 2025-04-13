package hw4;

import java.util.HashMap;

public class SimilarityCalculator {
    public double cosineSimilarity(HashMap<String, Integer> vec1, HashMap<String, Integer> vec2) {
        double dotPoroduct = 0;
        for (String key : vec1.keySet()) {
            if (vec2.containsKey(key)) {
                dotPoroduct += vec1.get(key) * vec2.get(key);
            }
        }
        return dotPoroduct / (calculateNorm(vec1) * calculateNorm(vec2));
    }
    
    private static double calculateNorm(HashMap<String, Integer> vec) {
        double norm = 0;
        for (String key : vec.keySet()) {
            norm += Math.pow(vec.get(key), 2);
        }   
        return Math.sqrt(norm);
    }
}
