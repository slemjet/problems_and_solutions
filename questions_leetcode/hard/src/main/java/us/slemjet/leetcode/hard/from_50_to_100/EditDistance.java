package us.slemjet.leetcode.hard.from_50_to_100;

import java.util.Arrays;

/**
 * 72. Edit Distance
 */
public class EditDistance {

    /**
     * Dp Bottom Up
     *
     * Runtime: 8 ms, 16.77%
     * Memory Usage: 5.01%
     */
    public int minDistance(String word1, String word2) {

        if (word1 == null && word2 == null) return -1;
        if (word1 == null || word1.length() == 0) return word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();

        char[] array1 = word1.toCharArray();
        char[] array2 = word2.toCharArray();

        int[][] cache = new int[array1.length][array2.length];
        Arrays.stream(cache).forEach(rows -> Arrays.fill(rows, -1));

        int dist = dist(word1.toCharArray(), word2.toCharArray(), 0, 0, cache);
        return dist;
    }

    private int dist(char[] array1, char[] array2, int i, int j, int[][] cache) {

        if (array1.length == i)
            return array2.length - j; // Reached end of 1 array -> return remaining elements of array 2
        if (array2.length == j)
            return array1.length - i; // Reached end of 2 array -> return remaining elements of array 1

        if (cache[i][j] != -1) return cache[i][j];

        int dist;

        if (array1[i] == array2[j]) {
            dist = dist(array1, array2, i + 1, j + 1, cache); // just skip for next elements
        } else {
            int insertDist = dist(array1, array2, i, j + 1, cache); // insert from 2 array -> skip to next element of 2 array
            int deleteDist = dist(array1, array2, i + 1, j, cache); // delete from 1 array -> skip to next element of 1 array
            int replaceDist = dist(array1, array2, i + 1, j + 1, cache); // replace element from 1 with element from 2 -> skip to both

            dist = Math.min(Math.min(insertDist, deleteDist), replaceDist) + 1;
        }

        return cache[i][j] = dist;
    }

    /**
     * Use recursion to select shortest distance
     */
    public int minDistanceRecursion(String word1, String word2) {

        if (word1 == null && word2 == null) return -1;
        if (word1 == null || word1.length() == 0) return word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();

        int dist = distRecursion(word1.toCharArray(), word2.toCharArray(), 0, 0);
        return dist;
    }

    private int distRecursion(char[] array1, char[] array2, int i, int j) {

        if (array1.length == i)
            return array2.length - j; // Reached end of 1 array -> return remaining elements of array 2
        if (array2.length == j)
            return array1.length - i; // Reached end of 2 array -> return remaining elements of array 1

        if (array1[i] == array2[j]) {
            int equalsDist = distRecursion(array1, array2, i + 1, j + 1); // just skip for next elements
            return equalsDist;
        } else {
            int insertDist = distRecursion(array1, array2, i, j + 1); // insert from 2 array -> skip to next element of 2 array

            int deleteDist = distRecursion(array1, array2, i + 1, j); // delete from 1 array -> skip to next element of 1 array

            int replaceDist = distRecursion(array1, array2, i + 1, j + 1); // replace element from 1 with element from 2 -> skip to both

            int minDist = Math.min(Math.min(insertDist, deleteDist), replaceDist);
            return minDist + 1;
        }
    }
}
