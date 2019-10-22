package us.slemjet.leetcode.hard.lists;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static us.slemjet.leetcode.hard.lists.ListNode.of;

class ReverseNodesInKGroupTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(of(1, 2, 3, 4, 5), 2, of(2, 1, 4, 3, 5)),
                Arguments.of(of(1, 2, 3, 4, 5), 3, of(3, 2, 1, 4, 5)),
                Arguments.of(of(1, 2, 3, 4), 4, of(4, 3, 2, 1))
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