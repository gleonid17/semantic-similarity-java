# Semantic Similarity using Distributional Semantics

A Java implementation of a semantic similarity system that learns relationships between words from large text collection and uses those relationships to answer synonym questions.

The project is based on the distributional hypothesis:

> Words that appear in similar contexts tend to have similar meanings.

Using sentence-level word co-occurrence statistics, the system builds semantic descriptors for words and compares them using cosine similarity.



## Features

-   Text parsing and tokenization
    
-   Semantic descriptor generation
    
-   Word co-occurrence analysis
    
-   Cosine similarity calculation
    
-   Synonym prediction
    
-   TOEFL-style evaluation framework
    
-   Result export to text files
    


## How It Works

### 1. Training

The program reads one or more text files and splits them into sentences and words.

Example:

```text
The cat sat on the mat.
The dog sat on the floor.

```

For each word, the system records which other words appear in the same sentence.

Example semantic descriptor:

```text
cat:
    sat -> 1
    on -> 1
    the -> 1
    mat -> 1

```

These co-occurrence counts form a vector representation of each word.

---

### 2. Similarity Calculation

Two words are compared using cosine similarity between their semantic descriptor vectors.

Words that appear in similar contexts receive higher similarity scores.

Examples:

```text
cat - dog     High similarity
cat - table   Low similarity

```

----------

### 3. Evaluation

The model is evaluated using TOEFL-style synonym questions.

Example:

```text
happy:
    delightful
    sad
    sedimentary

```

The algorithm selects the answer with the highest semantic similarity score.



## Project Structure

```text
.
├── src
│   ├── Coordinator.java
│   ├── SemanticDescriptorBuilder.java
│   ├── SemanticDescriptors.java
│   ├── SimilarityCalculator.java
│   ├── TextFileParser.java
│   ├── TextOperations.java
│   ├── TextParser.java
│   └── TOEFLEvaluator.java
│
├── data
│   ├── brown-train-sentences.txt
│   ├── pg2600.txt
│   ├── pg7178.txt
│   └── SynonymQuestions.txt
│
├── README.md
└── LICENSE

```
## Requirements

### Java Version

This project requires:

```text
Java 8 or later

```

You can verify your installation by running:

```bash
java -version
javac -version

```

If both commands return version information, Java is correctly installed.

---
### Installing Java

#### Windows

1.  Download the latest Java Development Kit (JDK) from Oracle or OpenJDK.
    
2.  Run the installer.
    
3.  Open Command Prompt and verify the installation:
    

```cmd
java -version
javac -version

```

If the commands are not recognized, restart your terminal or ensure Java has been added to your system PATH.

----

#### macOS

Using Homebrew:

```bash
brew install openjdk

```

Verify the installation:

```bash
java -version
javac -version

```

Alternatively, Java can be installed through Oracle's official installer.

----

#### Ubuntu / Debian

```bash
sudo apt update
sudo apt install default-jdk

```

Verify:

```bash
java -version
javac -version

```
-------------

#### Fedora

```bash
sudo dnf install java-latest-openjdk-devel

```

Verify:

```bash
java -version
javac -version

```

-----
#### Arch Linux

```bash
sudo pacman -S jdk-openjdk

```

Verify:

```bash
java -version
javac -version
```



## Compilation

```bash
javac src/*.java

```



## Running the Project

```bash
java -cp src Coordinator \
    data/SynonymQuestions.txt \
    data/brown-train-sentences.txt \
    data/pg2600.txt \
    data/pg7178.txt

```

The generated results are written to:

```text
Results.txt

```


## Example Output

```text
Question: happy

Choices:
- delightful
- sad
- sedimentary

Prediction: delightful

```


## Algorithms and Data Structures

### Data Structures

-   HashMap
    
-   ArrayList
    
-   Nested HashMaps for semantic descriptors
    

### Similarity Metric

-   Cosine Similarity
    


## Results

Using the included training files and evaluation dataset, the implementation achieved:

```text
56.25% accuracy

```

Performance depends heavily on the size and quality of the training files.


## Limitations

This project was designed as an educational implementation of distributional semantics.

Current limitations include:

-   Sentence-level context only
    
-   No stemming or lemmatization
    
-   No stop-word removal
    


## Authors

George Leonidou
Andreas Kristian Mylonas



## Academic Context

This project was originally developed as part of a university assignment exploring semantic similarity, vector-space representations of language, and Natural Language Processing techniques for the course "EPL133", Object Oriented Programming.

The repository has been cleaned up and preserved as a portfolio project demonstrating:

-   Object-Oriented Programming in Java
    
-   Data Structures
    
-   Text Processing
    
-   Similarity Metrics
    
-   Software Documentation

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.    