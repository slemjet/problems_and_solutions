package us.slemjet.leetcode.easy.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.tasks_101_150.LinkedListCycleII.ListNode;

import java.util.stream.Stream;

class LinkedListCycleIITest {

    private static Stream<Arguments> parameters() {
        ListNode loop1 = new ListNode(2);
        ListNode loop2 = new ListNode(1);
        return Stream.of(
                Arguments.of(getCase1ListNode(loop1), loop1),
                Arguments.of(getCase2ListNode(loop2), loop2),
                Arguments.of(getCase3ListNode(), null)
        );
    }

    private static ListNode getCase1ListNode(ListNode loop) {
        ListNode listnode0 = new ListNode(3);
        ListNode listnode2 = new ListNode(0);
        ListNode listnode3 = new ListNode(4);
        listnode0.next = loop;
        loop.next = listnode2;
        listnode2.next = listnode3;
        listnode3.next = loop;
        return listnode0;
    }

    private static ListNode getCase2ListNode(ListNode loop) {
        ListNode listnode1 = new ListNode(2);
        loop.next = listnode1;
        listnode1.next = loop;
        return loop ;
    }

    private static ListNode getCase3ListNode() {
        ListNode listnode0 = new ListNode(3);
        return listnode0;
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCanCompleteCircuit(ListNode head, ListNode expected) {
        // given
        LinkedListCycleII solution = new LinkedListCycleII();

        // when
        ListNode result = solution.detectCycle(head);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
