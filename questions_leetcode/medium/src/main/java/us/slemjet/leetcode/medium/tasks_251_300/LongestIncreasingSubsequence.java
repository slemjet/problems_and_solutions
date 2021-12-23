package us.slemjet.leetcode.medium.tasks_251_300;

import java.util.ArrayList;
import java.util.List;

/**
 * 300. Longest Increasing Subsequence
 */
public class LongestIncreasingSubsequence {

    /**
     * Use patience sorting algorithm
     * No need to keep the whole array - we only need the last (largest) values
     * tails[i], i = size, value - last value of sequence
     * The values are ordered in increasing order - we can use binary search to locate existing (or add new)
     * Separate counter to count size
     * (1) if x is larger than all tails, append it, increase the size by 1
     * (2) if tails[i-1] < x <= tails[i], update tails[i]
     *
     * Runtime: 89.75% of Java online submissions for Longest Increasing Subsequence.
     * Memory Usage: 85.33% of Java online submissions for Longest Increasing Subsequence.
     */
    public int lengthOfLIS(int[] nums) {

        int[] tails = new int[nums.length]; // Smallest last value of all the sequences of this size
        int size = 0;

        for (int num : nums) {
            int i = 0, j = size;
            while (i != j) { // Search for sequence ending with > this value
                int mid = (i + j) / 2;
                if (tails[mid] < num)
                    i = mid + 1;
                else
                    j = mid;
            }
            tails[i] = num;
            if (i == size)
                size++; // Added new value to existing sequence
        }

        return size;
    }

    /**
     * Naive approach.
     * Keep track on all the active lists (keeping largest first).
     * If current element is smaller - create a new sequence
     * If current element is larger - extend largest sequence with this number
     * <p>
     * Runtime: 35.77%
     * Memory Usage: 5.13%
     */
    public int lengthOfLISNaive(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>(); // Active lists. Largest - first

        for (int num : nums) {
            if (lists.isEmpty()) {
                lists.add(List.of(num)); // Just create a new list
            } else {
                for (int j = 0; j < lists.size(); j++) { // Iterate over all active liss
                    List<Integer> currList = lists.get(j);
                    Integer lastVal = currList.get(currList.size() - 1);

                    if (num < lastVal && j == lists.size() - 1) { // Current element is smallest of all last values -> create a new one
                        List<Integer> newList = List.of(num);
                        lists.add(newList);
                        lists.removeIf(list -> list.size() == newList.size() && list != newList); // Clear lists with same value
                        break;
                    } else if (num > lastVal) { // Create a new list, adding this number
                        List<Integer> newList = new ArrayList<>(currList);
                        newList.add(num);
                        lists.add(j, newList);
                        lists.removeIf(list -> list.size() == newList.size() && list != newList); // Clear lists with same value
                        break;
                    }
                }
            }
        }

        return lists.get(0).size();
    }

}
