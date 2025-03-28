package us.slemjet.leetcode.medium.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.ListNode;

import java.util.stream.Stream;

class ReverseLinkedListIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
                        2, 4, new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5)))))),
                Arguments.of(new ListNode(5), 1, 1, new ListNode(5))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(ListNode head, int left, int right, ListNode expected) {
        // given
        ReverseLinkedListII solution = new ReverseLinkedListII();

        // when
        ListNode result = solution.reverseBetween(head, left, right);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}