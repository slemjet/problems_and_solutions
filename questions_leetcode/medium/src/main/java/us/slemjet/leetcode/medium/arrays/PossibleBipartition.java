package us.slemjet.leetcode.medium.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PossibleBipartition {

    public boolean possibleBipartition(int N, int[][] dislikes) {

        Map<Integer, Set<Integer>> dislikesByPerson = new HashMap<>();

        for (int[] pair : dislikes) {
            int first = pair[0];
            int second = pair[1];

            Set<Integer> firstDislikes = dislikesByPerson.getOrDefault(first, new HashSet<>());
            firstDislikes.add(second);
            dislikesByPerson.put(first, firstDislikes);

            Set<Integer> secondDislikes = dislikesByPerson.getOrDefault(second, new HashSet<>());
            secondDislikes.add(first);
            dislikesByPerson.put(second, secondDislikes);
        }

        // -1 - first group, 0 - no group, 1 - second group
        int[] colors = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (colors[i] == 0 && !dfs(dislikesByPerson, colors, i, 1)) {
                return false; // check dislikes recursively
            }
        }

        return true;
    }

    private boolean dfs(Map<Integer, Set<Integer>> dislikesByPerson, int[] colors, int index, int color) {

        // assign color to current person
        colors[index] = color;

        // check dislikes
        Set<Integer> dislikes = dislikesByPerson.getOrDefault(index, new HashSet<>());

        for (int dislikedPerson : dislikes) {
            if (colors[dislikedPerson] == color)
                return false; // cannot have same color

            if (colors[dislikedPerson] == 0 && !dfs(dislikesByPerson, colors, dislikedPerson, -color))
                return false; // check dislikes of this person
        }

        return true;
    }


    public boolean possibleBipartitionArr(int N, int[][] dislikes) {

        boolean[][] dislikesByPerson = new boolean[N][N];

        for (int[] pair : dislikes) {
            int first = pair[0] - 1;
            int second = pair[1] - 1;
            dislikesByPerson[first][second] = true;
            dislikesByPerson[second][first] = true;
        }

        // -1 - first group, 0 - no group, 1 - second group
        int[] colors = new int[N + 1];

        for (int i = 1; i < N; i++) {
            if (colors[i] == 0 && !dfs(dislikesByPerson, colors, i, 1)) {
                return false; // check dislikes recursively
            }
        }

        return true;
    }

    private boolean dfs(boolean[][] dislikesByPerson, int[] colors, int index, int color) {

        // assign color to current person
        colors[index] = color;

        // check dislikes
        for (int dislikedPerson = 0; dislikedPerson < dislikesByPerson[index].length; dislikedPerson++) {
            if (dislikesByPerson[index][dislikedPerson]) {
                if (colors[dislikedPerson] == color)
                    return false; // cannot have same color

                if (colors[dislikedPerson] == 0 && !dfs(dislikesByPerson, colors, dislikedPerson, -color))
                    return false; // check dislikes of this person
            }
        }
        return true;
    }

}
