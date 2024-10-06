package us.slemjet.leetcode.medium.tasks_351_400;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 364. Nested List Weight Sum II
 * tags: LinkedIn
 */
public class NestedListWeightSumII {

    /**
     *  Time: O(n)  ->  52.21%
     *  Space:O(n)  ->  13.09%
     */
    public int depthSumInverse(List<NestedInteger> nestedList) {

        int result = 0;
        int maxDepth = getMaxDepth(nestedList);
        // implement maxDepth using stack



        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        int currDepth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            currDepth++;
            for (int i = 0; i < size; i++) {
                NestedInteger nestedInteger = queue.poll();
                if (nestedInteger.isInteger()) {
                    result += nestedInteger.getInteger() * (maxDepth - currDepth + 1);
                } else {
                    queue.addAll(nestedInteger.getList());
                }
            }
        }

        return result;

    }

    private int getMaxDepth(List<NestedInteger> nestedList) {

        int depth = 0;
        if (nestedList.isEmpty()) {
            return depth;
        }

        depth = 1;
        for (NestedInteger nestedInteger : nestedList) {
            if (!nestedInteger.isInteger()) {
                depth = Math.max(depth, 1 + getMaxDepth(nestedInteger.getList()));
            }
        }

        return depth;
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
