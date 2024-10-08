package us.slemjet.leetcode.medium.tasks_1201_1250;

/**
 * 1247. Minimum Swaps to Make Strings Equal
 */
public class MinimumSwapsToMakeStringsEqual {

    /**
     * Time: O(n)   ->  82.91%
     * Space:O(1)   ->  94.47%
     */
    public int minimumSwap(String s1, String s2) {

        int result;
        int xy = 0;
        int yx = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                // Count all non-matching pairs
                if (s1.charAt(i) == 'x') {
                    xy++;
                } else {
                    yx++;
                }
            }
        }

        // check if paris match
        if (xy % 2 != yx % 2) return -1;

        result = xy / 2 + yx / 2; // 1 operation to match same pairs xx -> yy | yy -> xx
        if (xy % 2 != 0) result += 2; // 2 operations to match reversed pair xy -> yx

        return result;

    }

    /**
     * Time: O(n^2)     ->  82.91%
     * Space:O(1)       ->  9.05%
     */
    public int minimumSwap2(String s1, String s2) {

        int result = 0;

        if (s1.length() != s2.length()) return -1;
        if (s1.equals(s2)) return 0;

        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        for (int i = 0; i < s1Chars.length; i++) {
            if (s1Chars[i] != s2Chars[i]) {
                int idx = i + 1;
                // Find char to swap
                while (idx < s1Chars.length) {
                    if (s1Chars[idx] != s2Chars[idx]) {

                        // Find same matching letter xx -> yy. Costs 1 swap
                        if (s1Chars[i] == s1Chars[idx]) {
                            s1Chars[idx] = s2Chars[idx];
                            s2Chars[i] = s1Chars[i];
                            result++;
                            break;
                        } else if (s2Chars[i] == s2Chars[idx]) {
                            s2Chars[idx] = s1Chars[idx];
                            s1Chars[i] = s2Chars[i];
                            result++;
                            break;
                        }
                    }
                    idx++;
                }
            }
        }

        for (int i = 0; i < s1Chars.length; i++) {
            if (s1Chars[i] != s2Chars[i]) {
                int idx = i + 1;
                // Find char to swap
                while (idx < s1Chars.length) {
                    if (s1Chars[idx] != s2Chars[idx]) {

                        // Find different matching letter xy -> yx. costs 2 swaps
                        if (s1Chars[i] == s2Chars[idx] && s1Chars[idx] == s2Chars[i]) {
                            s1Chars[idx] = s2Chars[idx];
                            s1Chars[i] = s2Chars[i];
                            result += 2;
                            break;
                        }
                    }
                    idx++;
                }
                if (idx == s1Chars.length) return -1;
            }
        }

        return result;
    }

}
