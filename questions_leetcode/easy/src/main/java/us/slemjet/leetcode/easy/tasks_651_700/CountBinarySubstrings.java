package us.slemjet.leetcode.easy.tasks_651_700;

import java.util.ArrayList;
import java.util.List;

/**
 * 696. Count Binary Substrings
 */
public class CountBinarySubstrings {

    /**
     * Time:    O(n)    ->  13.23%
     * Spce:    O(n)    ->  44.11%
     */
    public int countBinarySubstringsCountGroups(String s) {

        int result = 0;

        // Count groups
        List<Integer> groups = new ArrayList<>();
        boolean isZero = s.charAt(0) == '0';
        int group = 1;
        for (int i = 1; i < s.length(); i++) {
            boolean isCurrentZero = s.charAt(i) == '0';
            if (isZero != isCurrentZero) {
                groups.add(group);
                group = 1;
                isZero = isCurrentZero;
            } else {
                group++;
            }
        }
        groups.add(group);

        // Count subsets that can be created by these groups
        for (int i = 1; i < groups.size(); i++) {
            result += Math.min(groups.get(i), groups.get(i - 1));
        }

        return result;
    }

    /**
     * Time:    O(n)    ->  92.88%
     * Space:   O(1)    ->  80.41%
     */
    public int countBinarySubstringsLinear(String s) {

        int result = 0;

        char[] chars = s.toCharArray();
        Boolean isZero = null;
        int prevFlipped = 0;
        int prevPrevFlipped = -1;
        for (int i = 0; i < chars.length; i++) {
            boolean isCurrentZero = chars[i] == '0';

            if (isZero == null) {
                isZero = isCurrentZero;
            } else if (isZero != isCurrentZero) {
                // Flip occurs
                if (prevPrevFlipped != -1) { //  skip first flip
                    int prevCount = prevFlipped - prevPrevFlipped;
                    int currentCount = i - prevFlipped;
                    result += Math.min(prevCount, currentCount);
                }
                prevPrevFlipped = prevFlipped;
                prevFlipped = i;
                isZero = isCurrentZero;
            }
        }

        // Add last flip
        if (prevPrevFlipped != -1) {
            int prevCount = prevFlipped - prevPrevFlipped;
            int currentCount = chars.length - prevFlipped;
            result += Math.min(prevCount, currentCount);
        }

        return result;
    }
}
