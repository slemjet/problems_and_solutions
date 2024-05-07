package us.slemjet.leetcode.medium.tasks_2451_2500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.ListNode;

import java.util.stream.Stream;

class RemoveNodesFromLinkedListTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(ListNode.of(5, 2, 13, 3, 8), ListNode.of(13, 8)),
                Arguments.of(ListNode.of(1, 1, 1, 1), ListNode.of(1, 1, 1, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionStack(ListNode head, ListNode expected) {
        // given
        RemoveNodesFromLinkedList solution = new RemoveNodesFromLinkedList();

        // when
        ListNode result = solution.removeNodesStack(head);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionRecursion(ListNode head, ListNode expected) {
        // given
        RemoveNodesFromLinkedList solution = new RemoveNodesFromLinkedList();

        // when
        ListNode result = solution.removeNodesRecursion(head);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}