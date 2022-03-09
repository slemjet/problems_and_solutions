package us.slemjet.leetcode.medium.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_51_100.RemoveDuplicatesFromSortedListII.ListNode;

import java.util.stream.Stream;

class RemoveDuplicatesFromSortedListIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5))))))),
                        new ListNode(1, new ListNode(2, new ListNode(5)))),
                Arguments.of(
                        new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3))))),
                        new ListNode(2, new ListNode(3))),
                Arguments.of(
                        new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2)))),
                        new ListNode(1))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testDeleteDuplicates(ListNode head, ListNode expected) {
        // given
        RemoveDuplicatesFromSortedListII solution = new RemoveDuplicatesFromSortedListII();

        // when
        ListNode value = solution.deleteDuplicates(head);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }
}