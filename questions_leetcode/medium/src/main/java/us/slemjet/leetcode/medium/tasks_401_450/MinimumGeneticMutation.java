package us.slemjet.leetcode.medium.tasks_401_450;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 433. Minimum Genetic Mutation
 */
public class MinimumGeneticMutation {

    /**
     * Runtime: 55.26%
     * Memory Usage: 58.29%
     *
     * Memory: O(n)
     * Time: O(m^n * n^2 * m)
     */
    public int minMutation(String start, String end, String[] bank) {

        char[] letters = new char[]{'A', 'C', 'G', 'T'};
        Set<String> bankSet = Arrays.stream(bank).collect(Collectors.toSet());
        Set<String> visited = new HashSet<>();
        Queue<String> nodes = new LinkedList<>();
        nodes.add(start);

        int length = 0;

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            while (size-- > 0) {
                String word = nodes.poll();
                if (end.equals(word)) return length;

                for (int i = 0; i < word.length(); i++) {
                    for (char letter : letters) {
                        char[] wordChars = word.toCharArray();
                        wordChars[i] = letter;
                        String candidate = new String(wordChars);
                        if (!visited.contains(candidate) && bankSet.contains(candidate)) {
                            visited.add(candidate);
                            nodes.add(candidate);
                        }
                    }
                }
            }

            length++;
        }

        return -1;
    }
}
