package us.slemjet.leetcode.easy.tasks_451_500;

import java.util.Arrays;

/**
 * 455. Assign Cookies
 */
public class AssignCookies {

    /**
     * Time: O(nlogn)   ->  98.82%
     * Space: O(1)      ->  61.93%
     */
    public int findContentChildren(int[] g, int[] s) {

        int result = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int idx = 0;

        for (int child : g) {

            while (idx < s.length && s[idx] < child) {
                // Try next cookie
                idx++;
            }

            if (idx < s.length) {
                // Can use cookie
                result++;
                idx++;
            }
        }

        return result;
    }
}
