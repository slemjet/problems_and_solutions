package us.slemjet.leetcode.medium.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.ListNode;

import java.util.stream.Stream;

class ReorderListTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(ListNode.of(1, 2, 3, 4), ListNode.of(1, 4, 2, 3)),
                Arguments.of(ListNode.of(1, 2, 3, 4, 5), ListNode.of(1, 5, 2, 4, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(ListNode head, ListNode expected) {
        // given
        ReorderList solution = new ReorderList();

        // when
        solution.reorderList(head);

        // then
        Assertions.assertThat(head).isEqualTo(expected);
    }
}