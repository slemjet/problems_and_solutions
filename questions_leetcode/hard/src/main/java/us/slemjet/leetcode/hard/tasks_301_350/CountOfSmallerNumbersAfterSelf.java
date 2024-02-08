package us.slemjet.leetcode.hard.tasks_301_350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 315. Count of Smaller Numbers After Self
 */
public class CountOfSmallerNumbersAfterSelf {

    /**
     * Use merge sort, counting elements in right subset that are lesser than element in the left subset
     * <p>
     * Runtime: 30.74%
     * Memory Usage: 90.74%
     */
    public List<Integer> countSmaller(int[] nums) {

        List<Integer> counts = Arrays.asList(new Integer[nums.length]);
        Collections.fill(counts, 0);

        ElementWithIdx[] elements = new ElementWithIdx[nums.length];
        for (int i = 0; i < nums.length; i++) elements[i] = new ElementWithIdx(nums[i], i);

        mergeSortAndCount(elements, counts, 0, elements.length - 1);

        return counts;
    }

    private void mergeSortAndCount(ElementWithIdx[] elements, List<Integer> counts, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;
        mergeSortAndCount(elements, counts, start, mid);
        mergeSortAndCount(elements, counts, mid + 1, end);

        // Pointers to merge subsets
        int left = start;
        int right = mid + 1;

        List<ElementWithIdx> merged = new ArrayList<>();
        int rightElementsCount = 0; // Number of lesser elements to the right of this value
        while (left <= mid && right <= end) {
            int leftValue = elements[left].value;
            int rightValue = elements[right].value;
            if (leftValue > rightValue) {
                // Right element is smaller than left (and whole left subset since it is sorted)
                rightElementsCount++;
                merged.add(elements[right]);
                right++;
            } else {
                // Left element is less than right - add counts
                int leftOrigIndex = elements[left].index;
                counts.set(leftOrigIndex, counts.get(leftOrigIndex) + rightElementsCount);
                merged.add(elements[left]);
                left++;
            }
        }
        // Move all remaining elements into merged result
        while (left <= mid) {
            int leftOrigIndex = elements[left].index;
            counts.set(leftOrigIndex, counts.get(leftOrigIndex) + rightElementsCount);
            merged.add(elements[left]);
            left++;
        }
        while (right <= end) {
            merged.add(elements[right]);
            right++;
        }

        // Copy sorted array values
        int idx = start;
        for (ElementWithIdx element : merged) {
            elements[idx] = element;
            idx++;
        }
    }

    public static class ElementWithIdx {
        public int value;
        public int index;

        public ElementWithIdx(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
