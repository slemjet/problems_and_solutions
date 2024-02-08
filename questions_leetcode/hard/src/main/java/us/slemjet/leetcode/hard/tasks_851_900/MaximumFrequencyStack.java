package us.slemjet.leetcode.hard.tasks_851_900;

import java.util.*;

/**
 * 895. Maximum Frequency Stack
 */
public class MaximumFrequencyStack {

    /**
     * Keep  stacks by frequency. Each of such stacks contains elements in order of addition
     * Runtime: 31.69%
     * Memory Usage: 72.27%
     */
    static class FreqStackBucket {

        List<Stack<Integer>> stackByFrequency;
        Map<Integer, Integer> frequencyByValue;

        public FreqStackBucket() {
            stackByFrequency = new ArrayList<>();
            frequencyByValue = new HashMap<>();
        }

        public void push(int val) {
            // Increment frequency for input value
            frequencyByValue.put(val, frequencyByValue.getOrDefault(val, 0) + 1);
            int frequencyForVal = frequencyByValue.get(val);
            // Check if current frequency is larger than stack size
            if (frequencyForVal - 1 >= stackByFrequency.size())
                stackByFrequency.add(new Stack<>());
            // Add to stack
            stackByFrequency.get(frequencyForVal - 1).add(val);
        }

        public int pop() {
            // Get from stack for largest frequency
            int frequency = stackByFrequency.size();
            Integer lastItem = stackByFrequency.get(frequency - 1).pop();
            // Clear empty stack
            if (stackByFrequency.get(frequency - 1).isEmpty())
                stackByFrequency.remove(stackByFrequency.size() - 1);

            frequencyByValue.put(lastItem, frequencyByValue.get(lastItem) - 1);
            if (frequencyByValue.get(lastItem) == 0) frequencyByValue.remove(lastItem);

            return lastItem;
        }
    }

    /**
     * TLE
     */
    static class FreqStackTreeMap {

        LinkedList<Integer> elements;
        TreeMap<Integer, Integer> counts;

        public FreqStackTreeMap() {
            elements = new LinkedList<>();
            counts = new TreeMap<>();
        }

        public void push(int val) {
            elements.add(val);
            counts.put(val, counts.getOrDefault(val, 0) + 1);
        }

        public int pop() {
            Integer maxCount = counts.values().stream().max(Comparator.comparingInt(value -> value)).orElse(0);

            Integer maxValue = 0;

            if (!elements.isEmpty() && counts.get(elements.peekLast()).equals(maxCount)) {
                maxValue = elements.removeLast();
            } else {
                ListIterator<Integer> descendingIterator = elements.listIterator(elements.size() - 1);
                while (descendingIterator.hasPrevious()) {
                    Integer previous = descendingIterator.previous();
                    if (counts.get(previous).equals(maxCount)) {
                        descendingIterator.remove();
                        maxValue = previous;
                        break;
                    }
                }
            }

            maxCount--;
            if (maxCount == 0) counts.remove(maxValue);
            else counts.put(maxValue, maxCount);

            return maxValue;
        }
    }


/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
}
