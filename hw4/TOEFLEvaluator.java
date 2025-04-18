package hw4;

import java.util.ArrayList;

public class TOEFLEvaluator {
    private SemanticDescriptors map;   
    
    /**
     * Constructor for the TOEFLEvaluator class
     * @param map the semantic descriptors map to be used for evaluation
     */
    public TOEFLEvaluator(SemanticDescriptors map) {
        this.map = map;
    }

     /**
         * calls mostSimilarWord for each line in the file
         * saves the answer given by method
         * calculates the success rate of the algorithm
         * creates an output text file with the results
         * 
         * @param fileName the name of the file to be processed
         * @return void
         */
    public void runSimilarityTest(String fileName){
       
    }

    /**
     * approximates the most similar word in the choices array
     * in relation to the parameter 'word'
     * 
     * @param word word to be examined
     * @param choices array of words to be compared with the word
     * @return the most similar word in the choices array
     */
    public String mostSimilarWord(String word, ArrayList<String> choices) {
        
        return (new String());
    }
}