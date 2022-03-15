package us.slemjet.leetcode.medium.tasks_51_100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 71. Simplify Path
 */
public class SimplifyPath {

    /**
     * Runtime: 98.99%
     * Memory Usage: 77.20%
     */
    public String simplifyPath(String path) {

        Deque<String> queue = new LinkedList<>();

        String[] subStrings = path.split("/");
        for (String subString : subStrings) {
            if (subString.isEmpty() || subString.equals(".")) continue;
            else if (subString.equals("..")) {
                if (!queue.isEmpty()) queue.pollLast();
                if (!queue.isEmpty()) queue.pollLast();
                continue;
            }
            queue.offer("/");
            queue.offer(subString);
        }


        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) result.append(queue.pollFirst());
        return result.toString().isEmpty() ? "/" : result.toString();
    }
}
