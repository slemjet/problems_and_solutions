package us.slemjet.leetcode.medium.tasks_2451_2500;

import java.util.Arrays;

/**
 * 2491. Divide Players Into Teams of Equal Skill
 */
public class DividePlayersIntoTeamsOfEqualSkill {

    /**
     * Time: O(n)   -> 94.96%
     * Space:O(1)   -> 89.92%
     */
    public long dividePlayersBucket(int[] skill) {

        long result = 0;

        int[] buckets = new int[1001];

        Integer targetSum = null;

        for (int skillLevel : skill) {
            buckets[skillLevel]++;
        }

        int left = 0;
        int right = buckets.length - 1;

        while (left <= right) {
            while (left <= right && buckets[left] <= 0) left++; // move until there is a value
            if (left > right) return -1;
            buckets[left]--; // use value from left

            while (left <= right && buckets[right] <= 0) right--; // move until there is a value
            if (left > right) return -1;
            buckets[right]--; // use value from right

            if (buckets[left] < 0 || buckets[right] < 0) return -1;

            int currSum = left + right;
            if (targetSum == null) {
                targetSum = currSum;
            } else if (!targetSum.equals(currSum)) {
                return -1;
            }

            result += left * right;
            while (left <= right && buckets[left] <= 0) left++; // move until there is a value
            while (left <= right && buckets[right] <= 0) right--; // move until there is a value
        }

        return result;
    }

    /**
     * Time: O(nlogn)   ->  24.18%
     * Space:O(n)       ->  10.08%
     */
    public long dividePlayersSorting(int[] skill) {

        long result = 0L;

        Arrays.sort(skill);
        long sum = skill[0] + skill[skill.length - 1];

        for (int i = 0; i < skill.length / 2; i++) {
            int currSum = skill[i] + skill[skill.length - 1 - i];
            if (sum != currSum) {
                return -1;
            }
            result += (long) skill[i] * skill[skill.length - 1 - i];
        }

        return result;
    }
}
