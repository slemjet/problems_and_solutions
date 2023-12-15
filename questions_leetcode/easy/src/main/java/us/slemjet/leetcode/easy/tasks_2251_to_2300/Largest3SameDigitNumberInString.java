package us.slemjet.leetcode.easy.tasks_2251_to_2300;

/**
 * 2264. Largest 3-Same-Digit Number in String
 */
public class Largest3SameDigitNumberInString {

    /**
     * Time: O(n) -> 78.81%
     * Space: O(1) -> 59.93%
     */
    public String largestGoodInteger(String num) {

        String result = "";

        int idx = 2;

        while (idx < num.length()) {
            if (charIsCandidate(idx, num, result) && tripletIsCandidate(idx, num)) {
                String candidate = num.substring(idx - 2, idx + 1);
                if (candidate.compareTo(result) > 0) {
                    result = candidate;
                }
            }
            idx++;
        }

        return result;
    }

    private static boolean tripletIsCandidate(int idx, String num) {
        return num.charAt(idx) == num.charAt(idx - 1) && num.charAt(idx - 1) == num.charAt(idx - 2);
    }

    private static boolean charIsCandidate(int idx, String num, String result) {
        return result.isEmpty() || num.charAt(idx - 2) > result.charAt(0);
    }
}
