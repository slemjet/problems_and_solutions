package us.slemjet.leetcode.easy.tasks_1_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.ListNode;

import java.util.stream.Stream;

class MergeTwoSortedListsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(ListNode.of(1, 2, 4),
                        ListNode.of(1, 3, 4),
                        ListNode.of(1, 1, 2, 3, 4, 4)),
                Arguments.of(ListNode.of(1),
                        ListNode.of(2),
                        ListNode.of(1, 2))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void isValidTest(ListNode l1, ListNode l2, ListNode expected) {
        // given
        MergeTwoSortedLists solution = new MergeTwoSortedLists();

        // when
        ListNode merged = solution.mergeTwoLists(l1, l2);

        // then
        ListNode node = merged;
        ListNode expectedNode = expected;

        while (expectedNode != null) {
            Assertions.assertThat(node.val).isEqualTo(expectedNode.val);
            node = node.next;
            expectedNode = expectedNode.next;
        }
    }
}
