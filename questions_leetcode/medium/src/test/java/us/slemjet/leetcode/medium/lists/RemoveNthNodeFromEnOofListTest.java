package us.slemjet.leetcode.medium.lists;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import us.slemjet.leetcode.medium.lists.RemoveNthNodeFromEnOofList.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class RemoveNthNodeFromEnOofListTest {

    @Test
    void removeNthFromEnd1() {
        // given
        RemoveNthNodeFromEnOofList solution = new RemoveNthNodeFromEnOofList();
        ListNode node = new ListNode(1);

        // when
        ListNode listNode = solution.removeNthFromEnd(node, 1);

        // then
        Assertions.assertThat(listNode).isNull();
    }

    @Test
    void removeNthFromEnd2() {
        // given
        RemoveNthNodeFromEnOofList solution = new RemoveNthNodeFromEnOofList();
        // 1->2->3->4->5
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        // when
        ListNode listNode = solution.removeNthFromEnd(node, 2);

        // then
        Assertions.assertThat(listNode.val).isEqualTo(1);
        Assertions.assertThat(listNode.next.val).isEqualTo(2);
        Assertions.assertThat(listNode.next.next.val).isEqualTo(3);
        Assertions.assertThat(listNode.next.next.next.val).isEqualTo(5);
    }

    @Test
    void removeNthFromEnd3() {
        // given
        RemoveNthNodeFromEnOofList solution = new RemoveNthNodeFromEnOofList();
        // 1->2
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);

        // when
        ListNode listNode = solution.removeNthFromEnd(node, 2);

        // then
        Assertions.assertThat(listNode.val).isEqualTo(2);
    }
}