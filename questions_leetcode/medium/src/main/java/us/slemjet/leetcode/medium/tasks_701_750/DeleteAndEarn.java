package us.slemjet.leetcode.medium.tasks_701_750;

import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 740. Delete and Earn
 */
public class DeleteAndEarn {

    /**
     * Bottom Up Approach - Use Bucket Sort
     * <p>
     * Runtime: 19.79%
     * Memory Usage: 13.84%
     */
    public int deleteAndEarn(int[] nums) {

        int[] sums = new int[10000 + 1]; // Dp, containing all the sums by value

        for (int num : nums) {
            sums[num] += num;
        }

        for (int j = 2; j < sums.length; j++) {
            sums[j] = Math.max(sums[j] + sums[j - 2], sums[j - 1]);
        }

        return sums[sums.length - 1];
    }

    /**
     * Bottom up approach
     * <p>
     * Runtime: 24.24%
     * Memory Usage: 50.44%
     */
    public int deleteAndEarnBottomUp(int[] nums) {

        // Group sum of values by number and return array [num][sumValue]
        int[][] countByNum = IntStream.of(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(value -> value)))
                .entrySet().stream().map(entry -> new int[]{entry.getKey(), entry.getValue()})
                .sorted(Comparator.comparingInt(o -> o[0]))
                .toArray(int[][]::new);

        int result = countByNum[0][1];
        for (int i = 1; i < countByNum.length; i++) {
            int prevPrevValue = i >= 2 ? countByNum[i - 2][1] : 0;
            int[] prev = countByNum[i - 1];
            int[] curr = countByNum[i];

            // If values are next to each other - we cannot take their sums
            if (prev[0] == curr[0] - 1) {
                result = Math.max(curr[1] + prevPrevValue, prev[1]);
            } else {
                result = curr[1] + prev[1];
            }
            curr[1] = result;
        }
        return result;
    }

    /**
     * Top To Bottom
     *
     * Runtime: 6.34%
     * Memory Usage: 20.43%
     */
    public int deleteAndEarnTopToBottom(int[] nums) {

        int[][] countByNum = IntStream.of(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(value -> value)))
                .entrySet().stream().map(entry -> new int[]{entry.getKey(), entry.getValue()})
                .sorted(Comparator.comparingInt(o -> o[0]))
                .toArray(int[][]::new);

        int maxValue = countByNum[countByNum.length - 1][0];
        return countMax(countByNum, new Integer[maxValue], countByNum.length - 1);
    }

    private int countMax(int[][] countByNum, Integer[] memo, int i) {
        if (i < 0) return 0;
        if (i == 0) return countByNum[0][1];
        if (memo[i] != null) return memo[i];

        // If values are next to each other - we cannot take their sums
        if (countByNum[i - 1][0] == countByNum[i][0] - 1) {
            memo[i] = Math.max(countByNum[i][1] + countMax(countByNum, memo, i - 2), countMax(countByNum, memo, i - 1));
        } else {
            memo[i] = countByNum[i][1] + countMax(countByNum, memo, i - 1);
        }
        return memo[i];
    }
}
