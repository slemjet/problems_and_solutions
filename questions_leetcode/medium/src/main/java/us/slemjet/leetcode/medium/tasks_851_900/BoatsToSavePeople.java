package us.slemjet.leetcode.medium.tasks_851_900;

import java.util.Arrays;

/**
 * 881. Boats to Save People
 */
public class BoatsToSavePeople {

    /**
     * Sort + 2 pointers
     * Runtime: 40.25%
     * Memory Usage: 70.46%
     */
    public int numRescueBoats(int[] people, int limit) {

        int result = 0;

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            result++;
            right--;
        }

        return result;
    }

    /**
     * Use bucket sort + 2 pointers (tradeoff time for space)
     * Runtime: 98.89%
     * Memory Usage: 5.39%
     */
    public int numRescueBoatsBucket(int[] people, int limit) {

        int result = 0;

        int[] buckets = new int[limit + 1];
        for (int val : people) buckets[val]++;

        int left = 0;
        int right = buckets.length - 1;

        while (left <= right) {
            while (left <= right && buckets[right] <= 0) right--; // Look for next left
            while (left <= right && buckets[left] <= 0) left++; // Look for next right

            if (buckets[left] <= 0 && buckets[right] <= 0) break;

            result++;
            if (left + right <= limit) buckets[left]--; // Decrement both
            buckets[right]--;
        }

        return result;
    }
}
