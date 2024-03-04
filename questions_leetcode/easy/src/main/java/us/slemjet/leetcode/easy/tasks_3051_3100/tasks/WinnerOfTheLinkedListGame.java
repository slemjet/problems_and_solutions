package us.slemjet.leetcode.easy.tasks_3051_3100.tasks;

import us.slemjet.leetcode.common.ListNode;

/**
 * 3062. Winner of the Linked List Game
 */
public class WinnerOfTheLinkedListGame {

    /**
     *  Time: O(n)  ->  74.04%
     *  Space:O(1)  ->  94.07%
     */
    public String gameResult(ListNode head) {

        int score = 0;

        while (head != null && head.next != null) {
            if (head.val > head.next.val) {
                score++;
            } else {
                score--;
            }
            head = head.next.next;
        }

        return score > 0 ? "Even" : score < 0 ? "Odd" : "Tie";
    }
}
