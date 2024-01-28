package us.slemjet.leetcode.medium.tasks_401_450;

/**
 * 418. Sentence Screen Fitting
 */
public class SentenceScreenFitting {

    /**
     * Time: O(r + s.size*c)-> 58.94%
     * Space: O(s.size)     -> 33.28%
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {

        // How many words can add if starting from this word index
        int sentenceSize = sentence.length;
        int[] dp = new int[sentenceSize];


        for (int i = 0; i < sentenceSize; i++) {
            int length = 0; // Current combination length (all added words + spaces)
            int wordIdx = i; // Index of currently processed word
            int wordsCount = 0;
            while (length + sentence[wordIdx % sentenceSize].length() <= cols) { // While there is still space for next word
                length += sentence[wordIdx % sentenceSize].length(); // Add current word
                length += 1; // Add empty space
                wordIdx++; // To try next word
                wordsCount++;
            }
            dp[i] = wordsCount; // Add all words that can be added for this row
        }

        int wordsCount = 0;
        int startingWordIdx = 0; // Index of word at which this row starts

        for (int i = 0; i < rows; i++) {
            wordsCount += dp[startingWordIdx]; // Add words that can be added is tarting from this index
            startingWordIdx = (startingWordIdx + dp[startingWordIdx]) % sentenceSize; // Calculate next starting index
        }

        return wordsCount / sentenceSize; // Total words / words per sentence
    }

    /**
     * Simulation - TLE
     */
    public int wordsTypingSimulation(String[] sentence, int rows, int cols) {

        int count = 0;

        int wordIdx = 0;
        int currCols = cols;

        while (rows > 0) {
            while (currCols > 0) {
                while (sentence[wordIdx].length() <= currCols) {
                    // While can add next word
                    currCols -= sentence[wordIdx].length(); // Add word
                    wordIdx++;
                    if (currCols > 0) {
                        currCols--; // Add space
                    }
                    if (wordIdx == sentence.length) {
                        // Completed one sentence
                        count++;
                        wordIdx = 0;
                    }
                }
                while (currCols > 0) {
                    currCols--;
                }
            }
            System.out.println();
            // Finished processing row
            currCols = cols;
            rows--;
        }

        return count;
    }
}
