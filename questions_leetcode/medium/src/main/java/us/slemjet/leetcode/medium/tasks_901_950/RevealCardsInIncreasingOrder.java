package us.slemjet.leetcode.medium.tasks_901_950;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 950. Reveal Cards In Increasing Order
 */
public class RevealCardsInIncreasingOrder {

    /**
     * Simulation
     * Time: O(n)   ->  86.41%
     * Space:O(n)   ->  52.91%
     */
    public int[] deckRevealedIncreasing(int[] deck) {

        Arrays.sort(deck);

        // Calculate final indices position
        Queue<Integer> indices = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            indices.add(i);
        }

        int[] result = new int[deck.length];

        // Populate with indices first
        int idx = 0;
        while (!indices.isEmpty()){
            Integer deckIdx = indices.poll(); // Get card for current idx
            result[deckIdx] = deck[idx++];
            if(!indices.isEmpty()){
                Integer nextDeckIdx = indices.poll();
                indices.add(nextDeckIdx); // Put to end
            }
        }

        return result;
    }
}
