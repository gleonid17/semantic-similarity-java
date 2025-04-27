/**
 * The hw4 package provides the core functionality for text processing,
 * semantic descriptor construction, and similarity evaluation.
 *
 * <p>
 * Key components include:
 * <ul>
 * <li>{@link Coordinator}: Main entry point coordinating the workflow.</li>
 * <li>{@link TextParser}: Tokenizes raw text into sentences and words.</li>
 * <li>{@link TextFileParser}: Reads file contents and delegates parsing.</li>
 * <li>{@link SemanticDescriptorBuilder}: Builds co-occurrence maps from
 * tokenized text.</li>
 * <li>{@link SemanticDescriptors}: Model for storing and querying word
 * relations.</li>
 * <li>{@link SimilarityCalculator}: Computes cosine similarity between word
 * vectors.</li>
 * <li>{@link TOEFLEvaluator}: Evaluates synonym questions and writes
 * results.</li>
 * <li>{@link TextOperations}: Defines parsing operations for
 * implementations.</li>
 * </ul>
 *
 * @author George Leonidou
 * @author Andreas Kristian Mylonas
 * @since 27/04/2025
 */
package hw4;