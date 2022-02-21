package us.slemjet.leetcode.easy.from_51_to_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_51_to_100.RemoveDuplicatesFromSortedList.ListNode;

import java.util.stream.Stream;

class RemoveDuplicatesFromSortedListTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new ListNode(1, new ListNode(1, new ListNode(2))),
                        new ListNode(1, new ListNode(2))),
                Arguments.of(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3))))),
                        new ListNode(1, new ListNode(2, new ListNode(3)))),
                Arguments.of(new ListNode(1, new ListNode(1, new ListNode(1))),
                        new ListNode(1))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testDeleteDuplicates(ListNode head, ListNode expected) {
        // given
        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();

        // when
        ListNode result = solution.deleteDuplicates(head);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}