package us.slemjet.leetcode.medium.tasks_1251_1300;

import java.util.ArrayList;
import java.util.List;

/**
 * 1291. Sequential Digits
 */
public class SequentialDigits {

    /**
     * Precompute all possible variants and add ones that pass the criteria
     *
     * Time:    ->  100.00%
     * Space:   ->  6.81%
     */
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> result = new ArrayList<>();

        String nums = "123456789";

        // Precompute all possible variants
        List<Integer> candidates = new ArrayList<>();
        for (int size = 2; size <= nums.length(); size++) {
            for (int idx = 0; idx + size <= nums.length(); idx++) {
                candidates.add(Integer.parseInt(nums.substring(idx, idx + size)));
            }
        }

        // Add ones that pass the criteria
        for (int candidate : candidates) {
            if (candidate >= low && candidate <= high) {
                result.add(candidate);
            }
        }

        return result;
    }


    /**
     * Use sliding window on full sequence of digits
     * Runtime: 40.98%
     * Memory Usage: 45.90%
     */
    public List<Integer> sequentialDigits2(int low, int high) {

        List<Integer> sequence = new ArrayList<>();

        int num = 1;
        int cnt = 1;
        while (num < low / 100) {
            num *= 10;
            cnt++;
        }
        for (int i = 1; i <= 10 - cnt; i++) {
            int value = 0;
            for (int j = 0; j < cnt; j++) {
                value = value * 10 + j + i;
            }
            sequence.add(value);
        }

        List<Integer> result = new ArrayList<>();

        while (!sequence.isEmpty() && high > sequence.get(0)) {
            // Rebuild sequence
            int size = sequence.size();
            for (int i = 1; i < size; i++) {
                int value = sequence.get(i - 1) * 10 + 10 - size + i;
                sequence.set(i - 1, value);
                if (value >= low && value <= high) result.add(value);
                if (value > high) return result;
            }
            sequence.remove(sequence.size() - 1);
        }

        return result;
    }

    /**
     * Time: 100.00%
     * Space: 42.41%
     */
    public List<Integer> sequentialDigits3(int low, int high) {

        List<Integer> result = new ArrayList<>();

        String nums = "123456789";

        // Find starting num
        int size = String.valueOf(low).length();
        int idx = 0;
        int num = Integer.parseInt(nums.substring(idx, idx + size));

        while (num < low && idx + size < nums.length()) {
            if (idx + size < nums.length()) {
                idx++;
            } else {
                idx = 0;
                size++;
            }
            num = Integer.parseInt(nums.substring(idx, idx + size));
        }

        while (size <= nums.length()) {
            // Check all sequences
            int currNum = 0;
            while (idx + size <= nums.length()) {
                currNum = Integer.parseInt(nums.substring(idx, idx + size));
                if (currNum >= low && currNum <= high) {
                    result.add(currNum);
                    idx++;
                } else {
                    break;
                }
            }
            if (idx == 0 && currNum > high) {
                break; // No need to continue - all other values will be larger
            }
            size++; // Try with bigger size
            idx = 0;// From min sequence
        }

        return result;
    }


}
