import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * we import the entire java.io package to use the BufferedReader and PrintWriter classes
 * for reading from and writing to files respectively.
 * 
 * @author George Leonidou and Andreas Kristian Mylonas
 * @since 13/04/2025
 */

/**
 * This class is responsible for evaluating the TOEFL test by comparing a word
 * with a list of choices
 * based on the semantic descriptors built from text previously parsed by the
 * program,
 * it uses the {@link SemanticDescriptors} to access the similarity scores of
 * different
 * words from said text.
 */
public class TOEFLEvaluator {
    private SemanticDescriptors map;

    /**
     * Constructor for the TOEFLEvaluator class
     * 
     * @param map the semantic descriptors map to be used for evaluation
     */
    public TOEFLEvaluator(SemanticDescriptors map) {
        this.map = map;
    }

    /**
     * Calls {@link TOEFLEvaluator#mostSimilarWord(String, ArrayList)}
     * for each line in the file,
     * saves the answer given by method,
     * calculates the success rate of the algorithm,
     * creates an output text file with the results.
     * 
     * @param fileName the name of the file with the questions and answers.
     * @return void
     */
    public void runSimilarityTest(String fileName) {
        // opening input and output streams
        BufferedReader fileIn;
        PrintWriter fileOut = null;
        try {
            fileIn = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File was not found or could not be opened.");
            return;
        }
        try {
            fileOut = new PrintWriter(new FileOutputStream("Results.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Output file could not be created.");
            return;
        }

        // reading the first line of the file
        String line = null;
        try {
            line = fileIn.readLine();
        } catch (IOException e) {
            System.out.println("Error reading file.");
            return;
        }
        int totalQuestions = 0;
        int rightChoices = 0;
        while (line != null) {
            StringTokenizer lineTokens = new StringTokenizer(line, " ");
            if (lineTokens.countTokens() < 3) {
                fileOut.println("Question: " + (totalQuestions + 1) + "does not contain enough choices.");
                totalQuestions++;
                try {
                    line = fileIn.readLine();
                    continue;
                } catch (IOException e) {
                    System.out.println("Error reading file.");
                    return;
                }
            }
            String word = lineTokens.nextToken();
            String correctAnswer = lineTokens.nextToken();
            ArrayList<String> choices = new ArrayList<String>(5);
            while (lineTokens.hasMoreTokens()) {
                String choice = lineTokens.nextToken();
                choices.add(choice);
            }
            fileOut.print("Question: " + (totalQuestions + 1) + ": ");
            writeQuestion(fileOut, word, choices);
            String algorithmAnswer = mostSimilarWord(word, choices);
            writeResult(fileOut, algorithmAnswer, correctAnswer);
            if (algorithmAnswer.equals(correctAnswer)) {
                rightChoices++;
            }
            try {
                line = fileIn.readLine();
            } catch (IOException e) {
                System.out.println("Error reading file.");
                return;
            }
            totalQuestions++;
        }
        double successRate = (double) rightChoices / totalQuestions * 100.0;
        fileOut.println("\nSuccess rate: " + successRate + "%");
        try {
            fileIn.close();
        } catch (IOException e) {
            System.out.println("Error closing input file.");
        }
        fileOut.close();
    }

    /**
     * approximates the most similar word in the choices array
     * in relation to the parameter 'word'
     * 
     * @param word    word to be examined
     * @param choices ArrayList of words to be compared with the word
     * @return the most similar word in the choices array
     */
    public String mostSimilarWord(String word, ArrayList<String> choices) {
        if (choices.size() == 0) { // alreadt checked in runSimilarityTest
            return "NotEnoughChoices";
        }
        if (!map.containsKey(word)) {
            return "WordNotInTrainingFiles";
        }
        if (!choicesInTrainingFiles(choices)) {
            return "ChoicesNotInTrainingFiles";
        }
        double[] similarityScores = new double[choices.size()];
        for (int i = 0; i < choices.size(); i++) {
            similarityScores[i] = map.getSemanticValue(word, choices.get(i));
        }
        double maxScore = -1;
        int maxIndex = -1;
        for (int i = 0; i < similarityScores.length; i++) {
            if (similarityScores[i] > maxScore) {
                maxScore = similarityScores[i];
                maxIndex = i;
            }
        }
        return choices.get(maxIndex);
    }

    private void writeQuestion(PrintWriter fileOut, String word, ArrayList<String> choices) {
        fileOut.println(word + ":");
        for (String choice : choices) {
            fileOut.printf("%15s", choice);
            fileOut.println();
        }
    }

    private void writeResult(PrintWriter fileOut, String algorithmAnswer, String correctAnswer) {
        fileOut.println("Algorithm answer: " + algorithmAnswer);
        fileOut.println("Correct answer: " + correctAnswer);
        fileOut.println();
    }

    private boolean choicesInTrainingFiles(ArrayList<String> choices) {
        for (String choice : choices) {
            if (map.containsKey(choice)) {
                return true;
            }
        }
        return false;
    }
}