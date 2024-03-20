package us.slemjet.leetcode.medium.tasks_1651_1700;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.ListNode;

import java.util.stream.Stream;

class MergeInBetweenLinkedListsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(ListNode.of(10, 1, 13, 6, 9, 5), 3, 4,
                        ListNode.of(1000000, 1000001, 1000002),
                        ListNode.of(10, 1, 13, 1000000, 1000001, 1000002, 5)),
                Arguments.of(ListNode.of(0, 1, 2, 3, 4, 5, 6), 2, 5,
                        ListNode.of(1000000, 1000001, 1000002, 1000003, 1000004),
                        ListNode.of(0, 1, 1000000, 1000001, 1000002, 1000003, 1000004, 6)),
                Arguments.of(ListNode.of(0, 1, 2), 1, 1,
                        ListNode.of(1000000, 1000001, 1000002, 1000003),
                        ListNode.of(0, 1000000, 1000001, 1000002, 1000003, 2))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(ListNode list1, int a, int b, ListNode list2, ListNode expected) {
        // given
        MergeInBetweenLinkedLists solution = new MergeInBetweenLinkedLists();

        // when
        ListNode result = solution.mergeInBetween(list1, a, b, list2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}