package us.slemjet.leetcode.easy.tasks_851_900;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.ListNode;

import java.util.stream.Stream;

class MiddleOfTheLinkedListTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(ListNode.of(1, 2, 3, 4, 5), ListNode.of(3, 4, 5)),
                Arguments.of(ListNode.of(1, 2, 3, 4, 5, 6), ListNode.of(4, 5, 6))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(ListNode head, ListNode expected) {
        // given
        MiddleOfTheLinkedList solution = new MiddleOfTheLinkedList();

        // when
        ListNode result = solution.middleNode(head);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}