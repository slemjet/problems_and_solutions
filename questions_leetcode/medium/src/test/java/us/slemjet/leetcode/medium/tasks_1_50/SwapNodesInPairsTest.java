package us.slemjet.leetcode.medium.tasks_1_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.hard.lists.ListNode;

import java.util.stream.Stream;

import static us.slemjet.leetcode.hard.lists.ListNode.of;

class SwapNodesInPairsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(of(1, 2, 3, 4), of(2, 1, 4, 3)),
                Arguments.of(of(1, 2, 3, 4, 5), of(2, 1, 4, 3, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void swapPairs(ListNode head, ListNode expected) {
        // given
        SwapNodesInPairs solution = new SwapNodesInPairs();

        // when
        ListNode swapped = solution.swapPairs(head);

        // then
        ListNode expectedNode = expected;

        while (expectedNode != null) {
            Assertions.assertThat(swapped.val).isEqualTo(expectedNode.val);
            swapped = swapped.next;
            expectedNode = expectedNode.next;
        }
    }
}
