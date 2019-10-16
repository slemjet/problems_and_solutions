package us.slemjet.leetcode.easy.dynamic;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    private Map<Integer, Integer> memo = new HashMap<>();

    public int climbStairs(int n) {

        int result = climbStairsRec(0, n);
        return result;
    }

    private int climbStairsRec(int start, int end) {
        // reached end
        if (start > end)
            return 0;

        // on last stair
        if (start == end)
            return 1;

        if (!memo.containsKey(start)) {
            memo.put(start, climbStairsRec(start + 1, end) + climbStairsRec(start + 2, end));
        }

        return memo.get(start);
    }
}
