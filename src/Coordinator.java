import java.util.ArrayList;

/**
 * This class is the main entry point for the program.
 * It is responsible for coordinating the execution of the program and handling
 * any necessary setup or initialization.
 * 
 * @author George Leonidou and Andreas Kristian Mylonas
 * @since 19/04/2025
 */

public class Coordinator {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Correct input example: java Coordinator <similarityQuestionsFile> <textFile1> <textFile2> ...");
            System.out.println("Please provide at least one text file and one similarity questions file.");
            return;
        }
        System.out.println("Program started...");
        String similarityQuestionsFile = args[0];
        ArrayList<String> fileNames = new ArrayList<String>();
        for (int i = 1; i < args.length; i++) {
            fileNames.add(args[i]);
        }
        System.out.println("You have entered the following files: " + fileNames);
        System.out.println("The similarity questions file is: " + similarityQuestionsFile);
        System.out.println("We will now proceed...");
        ArrayList<ArrayList<String>> listOfLists = null;
        try {
            listOfLists = (new TextParser()).getListFromFiles(fileNames);
        } catch (Exception e) {
            System.out.println("An error occurred while parsing the text files: " + e.getMessage());
            return;
        }
        System.out.println("The text has been successfully parsed...");
        SemanticDescriptors semanticDescriptors = null;
        try {
            semanticDescriptors = SemanticDescriptorBuilder.listToMap(listOfLists);
        } catch (Exception e) {
            System.out.println("An error occurred while creating semantic descriptors: " + e.getMessage());
            return;
        }
        System.out.println("The semantic descriptors have been successfully created...");
        TOEFLEvaluator evaluator = new TOEFLEvaluator(semanticDescriptors);
        try {
            evaluator.runSimilarityTest(similarityQuestionsFile);
        } catch (Exception e) {
            System.out.println("An error occurred while running the similarity test: " + e.getMessage());
            return;
        }
        System.out.println("The results have successfully been written to the file 'Results.txt'.");
        System.out.println("Terminating program...");
    }
}
