package us.slemjet.leetcode.hard.tasks_1_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.ListNode;

import java.util.stream.Stream;


class MergeKSortedListsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new ListNode[]{
                        ListNode.of(1, 4, 5),
                        ListNode.of(1, 3, 4),
                        ListNode.of(2, 6)},
                        ListNode.of(1, 1, 2, 3, 4, 4, 5, 6)),
                Arguments.of(new ListNode[]{
                        ListNode.of(-2, -1, -1, -1), null},
                        ListNode.of(-2, -1, -1, -1)),
                Arguments.of(new ListNode[]{
                        ListNode.of(1, 2, 4),
                        ListNode.of(1, 3, 4)},
                        ListNode.of(1, 1, 2, 3, 4, 4)),
                Arguments.of(new ListNode[]{
                        ListNode.of(1),
                        ListNode.of(2)},
                        ListNode.of(1, 2))
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