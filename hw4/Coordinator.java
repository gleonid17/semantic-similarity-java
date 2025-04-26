package hw4;

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
        if (args.length < 2){
            System.out.println("Correct input example: java Coordinator <textFile1> <textFile2> ... <similarityQuestionsFile>");
            System.out.println("Please provide at least one text file and one similarity questions file.");
            return;
        }
        System.out.println("Program started...");
        System.out.println("Please enter the names of the files you'd like our program to process separated by spaces.");
        System.out.println("IMPORTANT: The files should be in the same directory as this program and be sure to include their extensions.");
        System.out.println("Type 'end' when you are done entering file names.");
        String similarityQuestionsFile = args[args.length - 1];
        ArrayList<String> fileNames = new ArrayList<String>();
        for (int i = 0; i < args.length - 1; i++) {
            fileNames.add(args[i]);
        }
        System.out.println("You have entered the following files: " + fileNames);
        System.out.println("The similarity questions file is: " + similarityQuestionsFile);
        System.out.println("We will now proceed...");
        ArrayList<ArrayList<String>> listOfLists = (new TextParser()).getListFromFiles(fileNames);
        System.out.println("The text has been successfully parsed...");
        // System.out.println(listOfLists);
        SemanticDescriptors semanticDescriptors = SemanticDescriptorBuilder.listToMap(listOfLists);
        System.out.println("The semantic descriptors have been successfully created...");
        // System.out.println(semanticDescriptors);
        System.out.println("Enter the name of the file with the similarity questions: ");
        TOEFLEvaluator evaluator = new TOEFLEvaluator(semanticDescriptors);
        evaluator.runSimilarityTest(similarityQuestionsFile);
        System.out.println("The results have successfully been written to the file 'Results.txt'.");
        System.out.println("Terminating program...");
    }
}
