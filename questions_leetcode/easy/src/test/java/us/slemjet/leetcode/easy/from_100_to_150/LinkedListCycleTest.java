package us.slemjet.leetcode.easy.from_100_to_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_100_to_150.LinkedListCycle.ListNode;

import java.util.stream.Stream;

class LinkedListCycleTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(getCase1ListNode(), true),
                Arguments.of(getCase2ListNode(), true),
                Arguments.of(getCase3ListNode(), false)
        );
    }

    private static ListNode getCase1ListNode() {
        ListNode listnode0 = new ListNode(3);
        ListNode listnode1 = new ListNode(2);
        ListNode listnode2 = new ListNode(0);
        ListNode listnode3 = new ListNode(-4);
        listnode0.next = listnode1;
        listnode1.next = listnode2;
        listnode2.next = listnode3;
        listnode3.next = listnode1;
        return listnode0;
    }

    private static ListNode getCase2ListNode() {
        ListNode listnode0 = new ListNode(3);
        ListNode listnode1 = new ListNode(2);
        listnode0.next = listnode1;
        listnode1.next = listnode0;
        return listnode0;
    }

    private static ListNode getCase3ListNode() {
        ListNode listnode0 = new ListNode(3);
        return listnode0;
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCanCompleteCircuit(ListNode head, boolean expected) {
        // given
        LinkedListCycle solution = new LinkedListCycle();

        // when
        boolean result = solution.hasCycle(head);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
