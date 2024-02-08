package us.slemjet.leetcode.easy.tasks_1801_1850;

/**
 * 1832. Check if the Sentence Is Pangram
 */
public class CheckIfTheSentenceIsPangram {

    /**
     * Runtime: 43.45%
     * Memory Usage: 47.93%
     */
    public boolean checkIfPangram(String sentence) {

        // Create target bitmask
        int bitmask = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            bitmask |=  1 << i - 'a';
        }

        // Get input bitmask
        int currentBitmask = 0;
        for (char aChar : sentence.toCharArray()) {
            currentBitmask |= 1 << (aChar - 'a');
        }

        // bitmask == currentBitmask should also work
        return (bitmask ^ currentBitmask) == 0;
    }
}
