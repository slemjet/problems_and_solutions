package us.slemjet.leetcode.hard.tasks_1_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.ListNode;

import java.util.stream.Stream;

class ReverseNodesInKGroupTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(ListNode.of(1, 2, 3, 4, 5), 2, ListNode.of(2, 1, 4, 3, 5)),
                Arguments.of(ListNode.of(1, 2, 3, 4, 5), 3, ListNode.of(3, 2, 1, 4, 5)),
                Arguments.of(ListNode.of(1, 2, 3, 4), 4, ListNode.of(4, 3, 2, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testReverseKGroup(ListNode head, int k, ListNode expected) {
        // given
        ReverseNodesInKGroup solution = new ReverseNodesInKGroup();

        // when
        ListNode reversed = solution.reverseKGroup1(head, k);

        // then
        ListNode expectedNode = expected;

        while (expectedNode != null) {
            Assertions.assertThat(reversed.val).isEqualTo(expectedNode.val);
            reversed = reversed.next;
            expectedNode = expectedNode.next;
        }
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testReverseKGroup2(ListNode head, int k, ListNode expected) {
        // given
        ReverseNodesInKGroup solution = new ReverseNodesInKGroup();

        // when
        ListNode reversed = solution.reverseKGroup2(head, k);

        // then
        ListNode expectedNode = expected;

        while (expectedNode != null) {
            Assertions.assertThat(reversed.val).isEqualTo(expectedNode.val);
            reversed = reversed.next;
            expectedNode = expectedNode.next;
        }
    }
}