EPL 133 - Assignment 4 - Team 26
Authors: Andreas Kristian Mylonas & George Leonidou

In this project we were tasked with implementing an algorithm that
is trained on text files to link the semantic value between words
and later can work to find synonyms.

Implementation details:
-> receives file names from the command line
-> parses the text into an ArrayList where each item in it is another 
ArrayList of a single String this way each token of the "outer" ArrayList
represents a sentence and the tokens of the "inner" ArrayList are single words
that belong in a sentence.
-> for the semantic descriptors we used a HashMap where the key is each individual word
that appears at least one time in the training files. the item of this HashMap is 
another HashMap where the key is String (word) representing the binary relation (word1, word2)
where the second word is any word which appears in the same sentence as word1.
The item of this hashmap is an Integer which represents how many times word1 and word2
appear in the same sentence.
-> then the algorithm proceeds to answer a synonym questionare and print the results
in a new output file "Results.txt"

How to run:
compilation command: javac hw4/*.java
execution command: java hw4.Coordinator <similarityQuestionsFile>      
<textFile1> <textFile2> …
