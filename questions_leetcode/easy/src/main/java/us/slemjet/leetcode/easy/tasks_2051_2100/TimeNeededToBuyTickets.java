package us.slemjet.leetcode.easy.tasks_2051_2100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2073. Time Needed to Buy Tickets
 */
public class TimeNeededToBuyTickets {

    /**
     * One pass through
     * Time: O(n)   ->  100.00%
     * Space:O(1)   ->  97.06%
     */
    public int timeRequiredToBuy(int[] tickets, int k) {

        int result = 0;

        int kTurns = tickets[k]; // That many times k buyer returns to the end of the queue

        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                result += Math.min(tickets[i], kTurns);
            } else {
                result += Math.min(tickets[i], kTurns - 1); // After k is fully sold - it wont get here
            }
        }

        return result;
    }

    /**
     * Simulation
     * Time: O(k*n) ->  32.29%
     * Space:O(n)   ->  7.53%
     */
    public int timeRequiredToBuy2(int[] tickets, int k) {

        int result = 0;

        Queue<int[]> byers = new LinkedList<>();

        for (int i = 0; i < tickets.length; i++) {
            byers.add(new int[]{i, tickets[i]});
        }

        while (!byers.isEmpty()) {
            int[] buyer = byers.poll();
            buyer[1]--;
            result++;
            if (buyer[1] != 0) {
                byers.add(buyer);
            } else {
                if (buyer[0] == k) {
                    break;
                }
            }
        }

        return result;
    }
}
