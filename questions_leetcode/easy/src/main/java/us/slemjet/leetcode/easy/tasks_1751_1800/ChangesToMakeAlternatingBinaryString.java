package us.slemjet.leetcode.easy.tasks_1751_1800;

/**
 * 1758. Minimum Changes To Make Alternating Binary String
 */
public class ChangesToMakeAlternatingBinaryString {

    /**
     * Time: O(n) -> 74.75%
     * Space: O(1) -> 10.82%
     */
    public int minOperations(String s) {

        int countStart0 = 0;
        int countStart1 = 0;

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            boolean isEvenIdx = i % 2 == 0;
            boolean isZero = currChar == '0';

            // Alternating starting from 0 > even numbers - 0, odd numbers = 1
            // Alternating starting from 1 -> even numbers - 1, odd numbers = 0
            if (isEvenIdx) {
                // Even index -> Staring from 0 are expected to have 0, starting from 1 are expected to have 1
                if (isZero) {
                    countStart1++;
                } else {
                    countStart0++;
                }
            } else {
                // Odd index -> Staring from 0 are expected to have 1, starting from 1 are expected to have 0
                if (isZero) {
                    countStart0++;
                } else {
                    countStart1++;
                }
            }
        }

        return Math.min(countStart0, countStart1);
    }
}
