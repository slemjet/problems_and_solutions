package us.slemjet.leetcode.hard.from_1_to_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.hard.lists.ListNode;

import java.util.stream.Stream;

import static us.slemjet.leetcode.hard.lists.ListNode.of;

class MergeKSortedListsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new ListNode[]{of(1, 4, 5), of(1, 3, 4), of(2, 6)}, of(1, 1, 2, 3, 4, 4, 5, 6)),
                Arguments.of(new ListNode[]{of(-2, -1, -1, -1), null}, of(-2, -1, -1, -1)),
                Arguments.of(new ListNode[]{of(1, 2, 4), of(1, 3, 4)}, of(1, 1, 2, 3, 4, 4)),
                Arguments.of(new ListNode[]{of(1), of(2)}, of(1, 2))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void mergeKListsDivAndConquer(ListNode[] lists, ListNode expected) {
        // given
        MergeKSortedLists solution = new MergeKSortedLists();

        // when
        ListNode result = solution.mergeKListsDivAndConquer(lists);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void mergeKListsPriorityQueue(ListNode[] lists, ListNode expected) {
        // given
        MergeKSortedLists solution = new MergeKSortedLists();

        // when
        ListNode result = solution.mergeKListsPriorityQueue(lists);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void mergeKListsSequentialMerge(ListNode[] lists, ListNode expected) {
        // given
        MergeKSortedLists solution = new MergeKSortedLists();

        // when
        ListNode result = solution.mergeKListsSequentialMerge(lists);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void mergeKListsPriorityQueue2(ListNode[] lists, ListNode expected) {
        // given
        MergeKSortedLists solution = new MergeKSortedLists();

        // when
        ListNode result = solution.mergeKListsPriorityQueue2(lists);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}