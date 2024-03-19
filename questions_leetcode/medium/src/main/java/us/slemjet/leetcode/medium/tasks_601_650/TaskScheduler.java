package us.slemjet.leetcode.medium.tasks_601_650;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 621. Task Scheduler
 */
public class TaskScheduler {

    /**
     * Count idle slots and add them to chars number
     * Time: O(nlogn)   ->  99.12%
     * Spce: O(n)       ->  9.81%
     */
    public int leastInterval(char[] tasks, int n) {

        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }

        Arrays.sort(counts); // Max counts comes last
        // Count empty slots between tasks - it is between so subtract 1 A___A___A___A -> (4 - 1) * 3
        int emptyCount = (counts[25] - 1) * n;

        for (int i = 24; i >= 0; i--) {
            if (counts[i] == 0) {
                break;
            } else {
                // We fill empty slots with current characters
                emptyCount -= Math.min(counts[25] - 1, counts[i]);
            }
        }

        int result = tasks.length;
        if (emptyCount > 0) {
            result += emptyCount;
        }

        return result;
    }

    /**
     * Use PriorityQueue to create resulting array
     * Time: O(nlogn)   ->  5.10%
     * Spce: O(n)       ->  98.44%
     */
    public int leastInterval2(char[] tasks, int n) {

        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }

        PriorityQueue<Task> tasksByCount = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.count, o1.count));

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                Task task = new Task((char) (i + 'A'), counts[i], 0);
                tasksByCount.add(task);
            }
        }

        List<Character> result = new ArrayList<>();

        while (!tasksByCount.isEmpty()) {

            // Search for next task with max count
            List<Task> delayedTasks = new ArrayList<>();
            Task nextTask = null;
            while (!tasksByCount.isEmpty()) {
                Task candidate = tasksByCount.poll();
                if (candidate.idx > result.size()) {
                    delayedTasks.add(candidate);
                } else {
                    nextTask = candidate;
                    break;
                }
            }
            tasksByCount.addAll(delayedTasks);

            if (nextTask == null) {
                result.add(' ');
            } else {
                result.add(nextTask.task);
                nextTask.idx = result.size() + n;
                nextTask.count--;
                if (nextTask.count > 0) {
                    tasksByCount.offer(nextTask);
                }
            }
        }

        return result.size();
    }

    static class Task {

        public Task(char task, int count, int idx) {
            this.task = task;
            this.count = count;
            this.idx = idx;
        }

        private char task;
        private int count;
        private int idx;
    }
}
