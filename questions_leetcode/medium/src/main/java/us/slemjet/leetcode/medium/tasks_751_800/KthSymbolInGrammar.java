package us.slemjet.leetcode.medium.tasks_751_800;

/**
 * 779. K-th Symbol in Grammar
 */
public class KthSymbolInGrammar {

    /**
     * 0            --> 4th iteration: n-- = 1, k = 2 - 2/2 = 1, result = 1 ^ 1 = 0 return 0
     *
     * 0 | (1)      --> 3rd iteration: n-- = 2, k = 2, result = 1
     *      ^
     * 0 (1) | 1 0          --> 2nd iteration: n-- = 3, k = 6 - 8/2 = 2, result = 0 ^ 1 = 1
     *    ^
     * 0 1 1 0 | 1 (0) 0 1  --> 1 st iteration: n-- = 4, k = 14 - 16/2 = 6, result = 1 ^ 1 = 0
     *              ^
     * 0 1 1 0 1 0 0 1 | 1 0 0 1 0 (1) 1 0  --> input: n = 5, k = 14, result = 1
     *                              ^
     *  n = 5, k = 14
     *
     * Runtime: than 100.00%
     * Memory Usage: 5.10%
     */
    public int kthGrammarRec(int n, int k) {
        return kthGrammarRec(n, k, 0);
    }

    private int kthGrammarRec(int n, int k, int value) {
        if (n == 1)
            return value;

        int size = (int) Math.pow(2, n - 1);
        if (k <= size / 2) return kthGrammarRec(n - 1, k, value); // If is in first half - just decrement n
        else return kthGrammarRec(n - 1, k - size / 2, value ^ 1); // If is in second half - flip value, and remove half
    }

    /**
     * Runtime: 100.00%
     * Memory Usage: 8.46%
     */
    public int kthGrammarIter(int n, int k) {

        int result = 0;
        while (n > 1) {
            int size = (int) Math.pow(2, n - 1);
            if (k > size / 2) {
                k -= size / 2;
                result ^= 1;
            }
            n--;
        }

        return result;
    }
}
