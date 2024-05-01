package us.slemjet.leetcode.easy.tasks_1951_2000;

/**
 * 2000. Reverse Prefix of Word
 */
public class ReversePrefixOfWord {

    /**
     * Time: O(n)   ->  100.00%
     * Space:O(n)   ->  18.43%
     */
    public String reversePrefix(String word, char ch) {

        int revIdx = 0;
        char[] chars = word.toCharArray();

        // Find index of reverse char
        while (revIdx < chars.length && chars[revIdx] != ch) {
            revIdx++;
        }

        // Reverse chars
        if (revIdx < chars.length) {
            for (int i = 0; i < revIdx; i++) {
                char tmp = chars[i];
                chars[i] = chars[revIdx];
                chars[revIdx] = tmp;
                revIdx--;
            }
        }

        return String.valueOf(chars);
    }
}
