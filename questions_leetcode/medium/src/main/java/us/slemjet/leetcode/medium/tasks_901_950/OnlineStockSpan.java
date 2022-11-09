package us.slemjet.leetcode.medium.tasks_901_950;

import java.util.Stack;

/**
 * 901. Online Stock Span
 */
public class OnlineStockSpan {

    /**
     * Runtime: 27 ms, faster than 71.81%
     * Memory Usage: 48.1 MB, less than 80.90%
     */
    public static class StockSpanner {

        // Monotonic stack - keeps stock in non-decreasing order
        Stack<int[]> stocks = new Stack<>();

        public StockSpanner() {

        }

        public int next(int price) {
            int inc = 1;
            if (stocks.isEmpty() || stocks.peek()[0] > price) {
                // Decreasing or empty
                stocks.add(new int[]{price, 1});
            } else {
                // Increasing
                while (!stocks.isEmpty() && stocks.peek()[0] <= price) {
                    int[] popped = stocks.pop();
                    inc += popped[1];
                }
                stocks.add(new int[]{price, inc});
            }
            return inc;
        }
    }
}
