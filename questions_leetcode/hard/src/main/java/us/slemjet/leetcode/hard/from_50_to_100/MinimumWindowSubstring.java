package us.slemjet.leetcode.hard.from_50_to_100;

/**
 * 76. Minimum Window Substring
 */
public class MinimumWindowSubstring {

    /**
     * Runtime: 78.64%
     * Memory Usage: 63.43%
     */
    public String minWindow(String s, String t) {
        String result = "";

        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return result;
        }

        int[] reference = new int[256];
        char[] input = s.toCharArray();
        char[] ref = t.toCharArray();

        int match = 0;
        for (int refChar : ref) {
            if (reference[refChar] == 0) {
                match++;
            }
            reference[refChar]++;
        }

        int[] current = new int[256];
        int currMatch = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < input.length; i++) {

            int endChar = input[end++];
            if (reference[endChar] > 0) {
                current[endChar]++;
                if (reference[endChar] == current[endChar]) {
                    // Has just stated to match
                    currMatch++;

                }
            }
            if (currMatch == match) {
                // Check if match found
                String currResult = s.substring(start, end);
                result = result.isEmpty() ? currResult : result.length() > currResult.length() ? currResult : result;
            }

            while (start <= i && currMatch == match) {
                // Slide left pointer
                char startChar = input[start++];
                if (reference[startChar] > 0) {
                    current[startChar]--;
                    if (reference[startChar] == current[startChar] + 1) {
                        // Has just stated to mismatch
                        currMatch--;

                        // Before it started to mismatch - it was another result
                        String currResult = s.substring(start - 1, end);
                        result = result.isEmpty() ? currResult : result.length() > currResult.length() ? currResult : result;
                    }
                }
            }
        }

        return result;
    }

    /**
     * Runtime: 13.78%
     * Memory Usage: 5.00%
     */
    public String minWindow2Pointers(String s, String t) {

        String result = "";
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return result;
        }

        int[] reference = new int[256];
        char[] input = s.toCharArray();
        char[] ref = t.toCharArray();

        int match = 0;
        for (int refChar : ref) {
            if (reference[refChar] == 0) {
                match++;
            }
            reference[refChar]++;
        }

        int[] current = new int[256];
        int currMatch = 0;
        int start = 0;
        int end = 0;

        while (end < input.length) {

            while (end < input.length && currMatch != match) {
                // Slide right pointer
                int endChar = input[end++];
                if (reference[endChar] > 0) {
                    current[endChar]++;
                    if (reference[endChar] == current[endChar]) {
                        // Has just stated to match
                        currMatch++;

                    }
                }
            }

            if (currMatch == match) {
                String currResult = s.substring(start, end);
                result = result.isEmpty() ? currResult : result.length() > currResult.length() ? currResult : result;
            }

            while (start <= end && currMatch == match) {
                // Slide left pointer
                char startChar = input[start++];
                if (reference[startChar] > 0) {
                    current[startChar]--;
                    if (reference[startChar] == current[startChar] + 1) {
                        // Has just stated to mismatch
                        currMatch--;

                        // Before it started to mismatch - it was another result
                        String currResult = s.substring(start - 1, end);
                        result = result.isEmpty() ? currResult : result.length() > currResult.length() ? currResult : result;
                    }
                }
            }

            // Shift till next reference key
            while (start < end && reference[input[start]] == 0) {
                start++;
            }
        }

        return result;
    }



}
