package us.slemjet.leetcode.medium.tasks_751_800;

import java.util.*;

/**
 * 752. Open the Lock
 */
public class OpenTheLock {

    /**
     * Time: O(n)    ->  5.03%
     * Space:O(n)    ->  71.27%
     */
    public int openLock(String[] deadends, String target) {

        int result = 0;

        Set<String> used = new HashSet<>(Arrays.asList(deadends));

        Queue<String> combinations = new LinkedList<>();

        if (!used.contains("0000")) {
            combinations.add("0000");
            used.add("0000");
        }

        while (!combinations.isEmpty()) {

            int size = combinations.size();

            for (int i = 0; i < size; i++) {
                String combination = combinations.poll();

                if (Objects.equals(combination, target)) {
                    return result;
                }

                System.out.print(combination + ", ");

                for (int j = 0; j < 4; j++) {
                    char[] combinationCharArray = combination.toCharArray();
                    int digit = Character.digit(combination.charAt(j), 10);
                    combinationCharArray[j] = Character.forDigit((digit + 1) % 10, 10);
                    String plusCombination = String.valueOf(combinationCharArray);
                    if (!used.contains(plusCombination)) {
                        combinations.add(plusCombination);
                        used.add(plusCombination);
                    }

                    combinationCharArray[j] = Character.forDigit((10 + digit - 1) % 10, 10);
                    String minusCombination = String.valueOf(combinationCharArray);
                    if (!used.contains(minusCombination)) {
                        combinations.add(minusCombination);
                        used.add(minusCombination);
                    }
                }
            }

            System.out.println();

            result++;

        }

        return -1;
    }
}
