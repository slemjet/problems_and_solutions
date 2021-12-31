package us.slemjet.leetcode.medium.tasks_301_350;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 341. Flatten Nested List Iterator
 */
public class FlattenNestedListIterator {

    /**
     * Runtime: 20.07%
     * Memory Usage: 5.80%
     */
    public class NestedIterator implements Iterator<Integer> {

        private Stack<NestedInteger> data = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                data.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return data.pop().getInteger();

        }

        @Override
        public boolean hasNext() {
            if (!data.isEmpty()) {
                if (!data.peek().isInteger()) {
                    List<NestedInteger> pop = data.pop().getList();
                    for (int i = pop.size() - 1; i >= 0; i--) {
                        data.push(pop.get(i));
                    }
                    return hasNext();
                }
            }
            return !data.isEmpty();
        }
    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

}
