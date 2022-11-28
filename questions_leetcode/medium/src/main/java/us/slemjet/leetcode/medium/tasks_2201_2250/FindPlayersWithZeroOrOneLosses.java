package us.slemjet.leetcode.medium.tasks_2201_2250;

import java.util.*;

/**
 * 2225. Find Players With Zero or One Losses
 */
public class FindPlayersWithZeroOrOneLosses {

    /**
     * Use Array
     * <p>
     * Runtime: 99.89%
     * Memory Usage: 98.84%
     */
    public List<List<Integer>> findWinners(int[][] matches) {

        List<List<Integer>> result = new ArrayList<>();

        int maxPlayer = 0;
        for (int[] match : matches) {
            // Get Max player for array size
            maxPlayer = Math.max(maxPlayer, Math.max(match[0], match[1]));
        }

        Integer[] lost = new Integer[maxPlayer + 1];

        for (int[] match : matches) {
            int winner = match[0];
            if (lost[winner] == null) {
                lost[winner] = 0; // Initialize winner
            }
            int loser = match[1];
            if (lost[loser] == null) {
                lost[loser] = 0; // Initialize loser
            }
            lost[loser]++;
        }

        List<Integer> noLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == null) continue;
            if (lost[i] == 0) noLoss.add(i);
            if (lost[i] == 1) oneLoss.add(i);
        }

        result.add(noLoss);
        result.add(oneLoss);

        return result;
    }

    /**
     * Use Map
     * <p>
     * Runtime: 15.94%
     * Memory Usage: 92.29%
     */
    public List<List<Integer>> findWinnersMap(int[][] matches) {
        Map<Integer, Integer> losses = new TreeMap<>();
        for (int[] m : matches) {
            losses.put(m[0], losses.getOrDefault(m[0], 0)); // Add winner
            losses.put(m[1], losses.getOrDefault(m[1], 0) + 1); // Add loser
        }
        List<List<Integer>> result = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for (Integer player : losses.keySet())
            if (losses.get(player) <= 1)
                result.get(losses.get(player)).add(player);
        return result;
    }

    /**
     * Use Set
     *
     * Runtime: 44.67%
     * Memory Usage: 70.96%
     */
    public List<List<Integer>> findWinnersSet(int[][] matches) {
        Set<Integer> zeroLoss = new HashSet<>(), oneLoss = new HashSet<>(), moreLosses = new HashSet<>();

        for (int[] match : matches) {
            int winner = match[0], loser = match[1];
            // Add winner.
            if (!oneLoss.contains(winner) && !moreLosses.contains(winner)) {
                zeroLoss.add(winner);
            }
            // Add or move loser.
            if (zeroLoss.contains(loser)) {
                zeroLoss.remove(loser);
                oneLoss.add(loser);
            } else if (oneLoss.contains(loser)) {
                oneLoss.remove(loser);
                moreLosses.add(loser);
            } else if (moreLosses.contains(loser)) {
                continue;
            } else {
                oneLoss.add(loser);
            }
        }

        List<List<Integer>> answer = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        answer.get(0).addAll(zeroLoss);
        answer.get(1).addAll(oneLoss);
        Collections.sort(answer.get(0));
        Collections.sort(answer.get(1));

        return answer;
    }
}
