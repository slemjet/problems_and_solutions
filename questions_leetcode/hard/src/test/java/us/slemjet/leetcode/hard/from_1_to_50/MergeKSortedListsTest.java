package us.slemjet.leetcode.hard.from_1_to_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.hard.from_1_to_50.MergeKSortedLists;
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
    void mergeKLists1(ListNode[] lists, ListNode expected) {
        // given
        MergeKSortedLists solution = new MergeKSortedLists();

        // when
        ListNode merged = solution.mergeKLists1(lists);

        // then
        ListNode node = merged;
        ListNode expectedNode = expected;

        while (expectedNode != null) {
            Assertions.assertThat(node.val).isEqualTo(expectedNode.val);
            node = node.next;
            expectedNode = expectedNode.next;
        }
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void mergeKLists2(ListNode[] lists, ListNode expected) {
        // given
        MergeKSortedLists solution = new MergeKSortedLists();

        // when
        ListNode merged = solution.mergeKLists2(lists);

        // then
        ListNode node = merged;
        ListNode expectedNode = expected;

        while (expectedNode != null) {
            Assertions.assertThat(node.val).isEqualTo(expectedNode.val);
            node = node.next;
            expectedNode = expectedNode.next;
        }
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void mergeKLists3(ListNode[] lists, ListNode expected) {
        // given
        MergeKSortedLists solution = new MergeKSortedLists();

        // when
        ListNode merged = solution.mergeKLists3(lists);

        // then
        ListNode node = merged;
        ListNode expectedNode = expected;

        while (expectedNode != null) {
            Assertions.assertThat(node.val).isEqualTo(expectedNode.val);
            node = node.next;
            expectedNode = expectedNode.next;
        }
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void mergeKLists4(ListNode[] lists, ListNode expected) {
        // given
        MergeKSortedLists solution = new MergeKSortedLists();

        // when
        ListNode merged = solution.mergeKLists4(lists);

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