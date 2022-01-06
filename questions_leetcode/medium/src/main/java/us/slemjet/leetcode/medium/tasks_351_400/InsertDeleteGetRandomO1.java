package us.slemjet.leetcode.medium.tasks_351_400;

import java.util.*;

/**
 * 380. Insert Delete GetRandom O(1)
 */
public class InsertDeleteGetRandomO1 {

    /**
     * Runtime: 57.55%
     * Memory Usage: 34.35%
     */
    static class RandomizedSet {
        private final List<Integer> values;
        private final Map<Integer, Integer> locByValue;
        private final Random random;

        public RandomizedSet() {
            values = new ArrayList<>();
            locByValue = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (locByValue.containsKey(val)) return false;
            locByValue.put(val, values.size());
            values.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!locByValue.containsKey(val)) return false;
            Integer currIdx = locByValue.get(val); // Current index of value to be removed
            int lastIdx = values.size() - 1; // Last element index.
            Integer lastValue = values.get(values.size() - 1);
            // set last element at the index of the element to be removed
            locByValue.put(lastValue, currIdx);
            values.set(currIdx, lastValue);
            locByValue.remove(val);
            values.remove(lastIdx); // Removing last element supposed to be quick (O(1))
            return true;
        }

        public int getRandom() {
            int rndIdx = random.nextInt(values.size());
            return values.get(rndIdx);
        }
    }
}
