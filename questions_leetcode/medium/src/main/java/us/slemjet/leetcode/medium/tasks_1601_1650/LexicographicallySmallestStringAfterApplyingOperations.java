package us.slemjet.leetcode.medium.tasks_1601_1650;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 1625. Lexicographically Smallest String After Applying Operations
 */
public class LexicographicallySmallestStringAfterApplyingOperations {

    /**
     * Use BFS
     * Time:    O(n*n)    ->    33.17%
     * Space:   O(n*n)    ->    81.91%
     */
    public String findLexSmallestString(String s, int a, int b) {

        String result = s;

        Queue<String> queue = new LinkedList<>();
        queue.offer(s);

        Set<String> processed = new HashSet<>();

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.compareTo(result) < 0) result = current;

            String added = add(current, a);
            if (!processed.contains(added)) {
                processed.add(added);
                queue.offer(added);
            }

            String rotated = rotate(current, b);
            if (!processed.contains(rotated)) {
                processed.add(rotated);
                queue.offer(rotated);
            }
        }

        return result;
    }

    private String add(String current, int a) {

        char[] chars = current.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 1) {
                int digit = chars[i] - '0';
                int newDigit = (digit + a) % 10;
                chars[i] = (char) ('0' + newDigit);
            }
        }

        return new String(chars);
    }

    private String rotate(String current, int b) {

        b = b % current.length();

        return current.substring(b) + current.substring(0, b);
    }
}
