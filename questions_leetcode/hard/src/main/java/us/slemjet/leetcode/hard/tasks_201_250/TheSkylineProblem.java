package us.slemjet.leetcode.hard.tasks_201_250;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 218. The Skyline Problem
 */
public class TheSkylineProblem {

    /**
     * Runtime: 59.77%
     * Memory Usage: 38.25%
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> result = new ArrayList<>();

        List<List<Integer>> heights = new ArrayList<>();
        for (int[] building : buildings) {
            // Store ending with '-' to distinguish it from the opening
            heights.add(Arrays.asList(building[0], building[2]));
            heights.add(Arrays.asList(building[1], -building[2]));
        }

        // Sort heights - need to have opening y first (before closing) if x is same -> Integer.compare(o2.get(1), o1.get(1))
        heights = heights.stream().sorted((o1, o2) ->
                        Objects.equals(o1.get(0), o2.get(0)) ? Integer.compare(o2.get(1), o1.get(1)) : Integer.compare(o1.get(0), o2.get(0)))
                .collect(Collectors.toList());

        TreeMap<Integer, Integer> heightsMap = new TreeMap<>((o1, o2) -> Integer.compare(o2, o1));
        heightsMap.put(0, 1); // Put initial occurrence for 0 height to have first and last drop/rise from 0 level
        int prevHeight = 0;

        for (List<Integer> height : heights) {
            Integer y = height.get(1);
            if (y >= 0) {
                heightsMap.put(y, heightsMap.getOrDefault(y, 0) + 1); // Add opening height
            } else {
                int count = heightsMap.getOrDefault(-y, 1) - 1; // Process closing height
                if (count == 0) {
                    heightsMap.remove(-y);
                } else {
                    heightsMap.put(-y, count);
                }
            }

            Integer currHeight = heightsMap.firstKey();// Get top value - skyline
            if (currHeight != prevHeight) {
                // Height has changed - add new point
                result.add(Arrays.asList(height.get(0), currHeight));
                prevHeight = currHeight;
            }
        }

        return result;
    }
}
