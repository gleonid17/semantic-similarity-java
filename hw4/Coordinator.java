package hw4;

import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println("Program started...");
        System.out
                .println("Please enter the names of the files you'd like our program to process separated by spaces.");
        System.out.println(
                "IMPORTANT: The files should be in the same directory as this program and be sure to include their extensions.");
        System.out.println("Type 'end' when you are done entering file names.");
        Scanner keyboard = new Scanner(System.in);
        ArrayList<String> fileNames = new ArrayList<String>(5);
        String input = keyboard.next();
        while (!input.equals("end")) {
            fileNames.add(input);
            input = keyboard.next();
        }
        System.out.println("You have entered the following files: " + fileNames);
        System.out.println("We will now proceed...");
        ArrayList<ArrayList<String>> listOfLists = (new TextParser()).getListFromFiles(fileNames);
        System.out.println("The text has been successfully parsed...");
        System.out.println(listOfLists);
        SemanticDescriptors semanticDescriptors = SemanticDescriptorBuilder.listToMap(listOfLists);
        System.out.println("The semantic descriptors have been successfully created...");
        System.out.println(semanticDescriptors);
        System.out.println("Enter the name of the file with the similarity questions: ");
        String fileName = keyboard.next();
        System.out.println("You have entered the following file: " + fileName);
        System.out.println("We will now proceed...");
        TOEFLEvaluator evaluator = new TOEFLEvaluator(semanticDescriptors);
        evaluator.runSimilarityTest(fileName);
        System.out.println("The results have successfully been written to the file 'Results.txt'.");
        System.out.println("Terminating program...");
        keyboard.close();
    }
}
