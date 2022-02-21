package us.slemjet.leetcode.easy.from_101_to_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static us.slemjet.leetcode.easy.from_101_to_150.ConvertSortedArrayToBinarySearchTree.TreeNode;

class ConvertSortedArrayToBinarySearchTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{-10, -3, 0, 5, 9},
                        new TreeNode(0,
                                new TreeNode(-3, new TreeNode(-10), null),
                                new TreeNode(9, new TreeNode(5), null))),
                Arguments.of(new int[]{1, 3},
                        new TreeNode(3, new TreeNode(1), null))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSortedArrayToBST(int[] nums, TreeNode expected) {
        // given
        ConvertSortedArrayToBinarySearchTree solution = new ConvertSortedArrayToBinarySearchTree();

        // when
        TreeNode result = solution.sortedArrayToBST(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
