package us.slemjet.leetcode.easy.from_1401_to_1450;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1436. Destination City
 */
public class DestinationCity {

    /**
     * Time: O(n) -> 79.16%
     * Space: O(n) -> 69.51%
     */
    public String destCity(List<List<String>> paths) {

        Set<String> from = new HashSet<>();
        Set<String> to = new HashSet<>();

        for (List<String> route : paths) {
            from.add(route.get(0));
            to.add(route.get(1));
        }

        for (String dest : to) {
            if (!from.contains(dest)) {
                return dest;
            }
        }

        return "";
    }
}
