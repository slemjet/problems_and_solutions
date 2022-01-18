package us.slemjet.leetcode.medium.tasks_401_450.tasks;

/**
 * 413. Arithmetic Slices
 */
public class ArithmeticSlices {

    /**
     * Runtime: 100.00%
     * Memory Usage: 37.92%
     */
    public int numberOfArithmeticSlices(int[] nums) {

        int newCombinations = 0;
        int sumCombinations = 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                // Continue sequence
                newCombinations += 1; // New combinations increased by 1
                sumCombinations += newCombinations; // Add to total sum
            } else {
                newCombinations = 0; // Reset sequence
            }
        }

        return sumCombinations;
    }

    /**
     * Runtime: 100.00%
     * Memory Usage: 65.59%
     */
    public int numberOfArithmeticSlices2(int[] nums) {

        int result = 0;
        int sequenceStartIdx = -1;
        int currDelta;
        int prevDelta = 0;

        for (int i = 1; i < nums.length; i++) {
            currDelta = nums[i] - nums[i - 1];

            if (i > 1) {
                if (currDelta == prevDelta) { // Sequence in progress
                    if (sequenceStartIdx == -1) {
                        sequenceStartIdx = i - 2;
                    }
                    // For each new point of length to the existing we add new combinations: 1 2 3 4 -> length - 1
                    // 3 - > 1 (1 new), 4 -> 3 (1 prev + 2 new) 5 -> 6 (3 prev + 3 new)
                    result += i - sequenceStartIdx - 1;
                } else {
                    sequenceStartIdx = -1;
                }
            }

            prevDelta = currDelta;
        }


        return result;
    }
}
