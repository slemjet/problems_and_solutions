package us.slemjet.leetcode.medium.tasks_1501_1550;

/**
 * 1529. Minimum Suffix Flips
 */
public class MinimumSuffixFlips {

    /**
     * Time: O(n)   ->  100.00%
     * Space:O(1)   ->  87.64%
     */
    public int minFlips(String target) {

        int flipCount = 0;
        char lastChar = '0';

        for (char currChar : target.toCharArray()) {
            if (currChar != lastChar) { // Only need to flip if char changed
                flipCount++;
                lastChar = currChar;
            }
        }

        return flipCount;
    }

    /**
     * Time: O(n)   ->  10.04%
     * Space:O(1)   ->  39.00%
     */
    public int minFlips2(String target) {
        int flipCount = 0;
        boolean isFlipped = false;

        for (int index = 0; index < target.length(); ) {
            char currentChar = target.charAt(index);

            if ((currentChar == '1' && !isFlipped) || (currentChar == '0' && isFlipped)) {
                flipCount++;
                isFlipped = !isFlipped;

                // Skip all consecutive characters that are the same as current
                while (index < target.length() && target.charAt(index) == currentChar) {
                    index++;
                }
            } else {
                index++;
            }
        }

        return flipCount;
    }
}
