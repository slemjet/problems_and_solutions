package us.slemjet.leetcode.medium.tasks_1151_1200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.ListNode;

import java.util.stream.Stream;

class RemoveZeroSumConsecutiveNodesFromLinkedListTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(ListNode.of(1, 2, -3, 3, 1), ListNode.of(3, 1)),
                Arguments.of(ListNode.of(1, 2, 3, -3, 4), ListNode.of(1, 2, 4)),
                Arguments.of(ListNode.of(1, 2, 3, -3, -2), ListNode.of(1)),
                Arguments.of(ListNode.of(0, 0), ListNode.of()),
                Arguments.of(ListNode.of(1, 3, 2, -3, -2, 5, 5, -5, 1), ListNode.of(1, 5, 1)),
                Arguments.of(ListNode.of(-2, -1, 1, -1, 1, -1, 2), ListNode.of(-2, -1, 2)),
                Arguments.of(ListNode.of(2, 2, -2, 1, -1, -1), ListNode.of(2, -1))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(ListNode head, ListNode expected) {
        // given
        RemoveZeroSumConsecutiveNodesFromLinkedList solution = new RemoveZeroSumConsecutiveNodesFromLinkedList();

        // when
        ListNode result = solution.removeZeroSumSublists(head);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution2(ListNode head, ListNode expected) {
        // given
        RemoveZeroSumConsecutiveNodesFromLinkedList solution = new RemoveZeroSumConsecutiveNodesFromLinkedList();

        // when
        ListNode result = solution.removeZeroSumSublists2(head);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}