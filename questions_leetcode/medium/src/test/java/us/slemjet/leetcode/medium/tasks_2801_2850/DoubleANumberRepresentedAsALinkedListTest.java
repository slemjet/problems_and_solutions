package us.slemjet.leetcode.medium.tasks_2801_2850;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.ListNode;

import java.util.stream.Stream;

class DoubleANumberRepresentedAsALinkedListTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(ListNode.of(1, 8, 9), ListNode.of(3, 7, 8)),
                Arguments.of(ListNode.of(9, 9, 9), ListNode.of(1, 9, 9, 8))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionStack(ListNode head, ListNode expected) {
        // given
        DoubleANumberRepresentedAsALinkedList solution = new DoubleANumberRepresentedAsALinkedList();

        // when
        ListNode result = solution.doubleItStack(head);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionDoubleReverse(ListNode head, ListNode expected) {
        // given
        DoubleANumberRepresentedAsALinkedList solution = new DoubleANumberRepresentedAsALinkedList();

        // when
        ListNode result = solution.doubleItDoubleReverse(head);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}