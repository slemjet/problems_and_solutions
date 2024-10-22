package us.slemjet.leetcode.medium.tasks_151_200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 187. Repeated DNA Sequences
 */
public class RepeatedDNASequences {

    /**
     * Time:    O(n)    ->  93.67%
     * Space:   O(n)    ->  41.11%
     */
    public List<String> findRepeatedDnaSequences(String s) {

        Set<String> result = new HashSet<>();

        Set<String> seen = new HashSet<>();

        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            if (!seen.add(sub))
                result.add(sub);
        }

        return new ArrayList<>(result);
    }
}
