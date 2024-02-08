package us.slemjet.leetcode.easy.tasks_1_50;

/**
 * 38. Count and Say
 */
public class CountAndSay {

    /**
     * Using to pointers technique to move for repetitions and store difference in indices as number of occurrences
     * and value at start index as value
     *  Time complexity: O(n*m)
     *  Space complexity: O(n)
     *
     * Runtime: 67.60%
     * Memory Usage: 100.00%
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String result = "1";
        if (n == 1)
            return result;

        while (n > 1) {
            StringBuilder current = new StringBuilder();
            int valStartIdx = 0; // index of first occurrence of value
            int valEndIdx = 0; // index of current occurrence of value

            while (valEndIdx < result.length()) {
                while (valEndIdx < result.length() && result.charAt(valStartIdx) == result.charAt(valEndIdx))
                    valEndIdx++; // Skip repetitions
                // number of values will be difference in indices
                current.append(valEndIdx - valStartIdx);
                current.append(result.charAt(valStartIdx));
                valStartIdx = valEndIdx;
            }
            result = current.toString();
            n--;
        }
        return result;
    }
}
