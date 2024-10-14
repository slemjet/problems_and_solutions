package us.slemjet.leetcode.easy.tasks_3201_3250;

/**
 * 3216. Lexicographically Smallest String After a Swap
 */
public class LexicographicallySmallestStringASwap {

    /**
     * Time: O(n)   ->  100.00%
     * Space:O(1)   ->  71.57%
     */
    public String getSmallestString(String s) {

        char[] chars = s.toCharArray();

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] % 2 != chars[i - 1] % 2) continue;

            if (chars[i] < chars[i - 1]) {
                // Swap
                char tmp = chars[i];
                chars[i] = chars[i - 1];
                chars[i - 1] = tmp;
                break;
            }
        }

        return new String(chars);
    }
}
