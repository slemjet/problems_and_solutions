package us.slemjet.leetcode.hard.from_351_to_400;

import java.util.*;

/**
 * 381. Insert Delete GetRandom O(1) - Duplicates allowed
 */
public class InsertDeleteGetRandomO1DuplicatesAllowed {

    /**
     * Runtime: 98.60%
     * Memory Usage: 92.91%
     */
    static class RandomizedCollection {
        private final List<Integer> values;
        private final Map<Integer, Set<Integer>> locByValue; // Holds all positions of current number
        private final Random random;

        public RandomizedCollection() {
            values = new ArrayList<>();
            locByValue = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            boolean contains = locByValue.containsKey(val);
            if (!contains) locByValue.put(val, new HashSet<>());
            locByValue.get(val).add(values.size());
            values.add(val);
            return !contains;
        }

        public boolean remove(int val) {
            if (!locByValue.containsKey(val)) return false;
            Set<Integer> currPositions = locByValue.get(val);
            Integer currIdx = currPositions.iterator().next(); // Current index of value to be removed
            int lastIdx = values.size() - 1; // Last element index.
            Integer lastValue = values.get(lastIdx);
            // set last element at the index of the element to be removed
            Set<Integer> lastPositions = locByValue.get(lastValue);
            lastPositions.remove(lastIdx);
            if (val != lastValue) {
                lastPositions.add(currIdx);
                currPositions.remove(currIdx);
            }
            if (currPositions.isEmpty()) {
                locByValue.remove(val); // Remove whole set of positions
            }

            values.set(currIdx, lastValue);
            values.remove(lastIdx); // Removing last element supposed to be quick (O(1))
            return true;
        }

        public int getRandom() {
            int rndIdx = random.nextInt(values.size());
            return values.get(rndIdx);
        }
    }
}
