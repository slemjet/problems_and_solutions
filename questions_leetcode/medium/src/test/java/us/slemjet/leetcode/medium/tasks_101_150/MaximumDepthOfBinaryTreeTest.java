package us.slemjet.leetcode.medium.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static us.slemjet.leetcode.medium.tasks_101_150.MaximumDepthOfBinaryTree.TreeNode;

class MaximumDepthOfBinaryTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // [3,9,20,null,null,15,7] -> 3
                Arguments.of(
                        new TreeNode(3,
                                new TreeNode(9, null, null),
                                new TreeNode(20,
                                        new TreeNode(15), new TreeNode(7))),
                        3),
                // [1,null,2] -> [2]
                Arguments.of(new TreeNode(1, null, new TreeNode(2)), 2),
                // [] -> 0
                Arguments.of(null, 0),
                // [0] -> 1
                Arguments.of(new TreeNode(0), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testZigzagLevelOrder(TreeNode root, int expected) {
        // given
        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();

        // when
        int result = solution.maxDepth(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
