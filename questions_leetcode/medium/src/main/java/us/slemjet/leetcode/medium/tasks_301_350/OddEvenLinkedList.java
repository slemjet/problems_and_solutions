package us.slemjet.leetcode.medium.tasks_301_350;

public class OddEvenLinkedList {


    /**
     Runtime: 100.00%
     Memory Usage: 84.52%
     */
    public ListNode oddEvenList(ListNode head) {

        // Will contain first nodes as next elements
        ListNode oddRoot = new ListNode();
        ListNode evenRoot = new ListNode();

        // Initiate the last node values
        ListNode lastOdd = oddRoot;
        ListNode lastEven = evenRoot;

        // switch to check if is odd or even
        boolean isOdd = true;

        while (head != null) {

            if (isOdd) {
                // append to odd list
                lastOdd.next = head;
                lastOdd = lastOdd.next;
            } else {
                // append to even list
                lastEven.next = head;
                lastEven = lastEven.next;
            }

            // switch to next node
            isOdd = !isOdd;
            head = head.next;
        }

        // link last odd to first even
        lastOdd.next = evenRoot.next;
        lastEven.next = null; // remove redundant tail

        return oddRoot.next;
    }


    ListNode lastOdd = null;
    ListNode lastEven = null;
    ListNode next = null;
    ListNode nextNext = null;
    ListNode firstEven = null;
    ListNode firstOdd = null;

    /**
     * Runtime: 17.39%
     * Memory Usage: 54.66%
     */
    public ListNode oddEvenListMy(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        firstOdd = lastOdd = new ListNode(head.val);
        firstEven = lastEven = new ListNode(head.next.val);
        next = head.next.next;

        traverseList(next, lastOdd, lastEven, true);

        lastOdd.next = firstEven;

        return firstOdd;
    }

    private void traverseList(ListNode next, ListNode lastOdd, ListNode lastEven, boolean isOdd) {
        this.nextNext = next.next;
        next.next = null;
        if (isOdd) {
            this.lastOdd.next = next;
            this.lastOdd = lastOdd.next;
        } else {
            this.lastEven.next = next;
            this.lastEven = lastEven.next;
        }
        if (nextNext == null) {
            this.lastOdd.next = null;
            this.lastEven.next = null;
            return;
        }
        traverseList(this.nextNext, this.lastOdd, this.lastEven, !isOdd);
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
