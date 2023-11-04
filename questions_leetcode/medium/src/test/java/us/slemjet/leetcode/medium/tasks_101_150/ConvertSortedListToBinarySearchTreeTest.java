package us.slemjet.leetcode.medium.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_101_150.ConvertSortedListToBinarySearchTree.ListNode;
import us.slemjet.leetcode.medium.tasks_101_150.ConvertSortedListToBinarySearchTree.TreeNode;

import java.util.stream.Stream;

class ConvertSortedListToBinarySearchTreeTest {

    private static Stream<Arguments> parameters2Pointers() {
        return Stream.of(
                Arguments.of(new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9))))),
                        new TreeNode(0,
                                new TreeNode(-3, new TreeNode(-10), null),
                                new TreeNode(9, new TreeNode(5), null))),
                Arguments.of(new ListNode(), new TreeNode())
        );
    }

    @ParameterizedTest
    @MethodSource("parameters2Pointers")
    void testSortedListToBST2Pointers(ListNode head, TreeNode expected) {
        // given
        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();

        // when
        TreeNode result = solution.sortedListToBST2Pointers(head);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> parametersArray() {
        return Stream.of(
                Arguments.of(new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9))))),
                        new TreeNode(0,
                                new TreeNode(-10, null, new TreeNode(-3)),
                                new TreeNode(5, null, new TreeNode(9)))),
                Arguments.of(new ListNode(), new TreeNode())
        );
    }

    @ParameterizedTest
    @MethodSource("parametersArray")
    void testSortedListToBSTArray(ListNode head, TreeNode expected) {
        // given
        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();

        // when
        TreeNode result = solution.sortedListToBSTArray(head);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}