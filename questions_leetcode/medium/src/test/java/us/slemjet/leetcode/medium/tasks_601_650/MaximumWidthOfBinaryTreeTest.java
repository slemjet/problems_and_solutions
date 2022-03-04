package us.slemjet.leetcode.medium.tasks_601_650;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_601_650.MaximumWidthOfBinaryTree.TreeNode;

import java.util.stream.Stream;

class MaximumWidthOfBinaryTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new TreeNode(1,
                        new TreeNode(3, new TreeNode(5), new TreeNode(3)),
                        new TreeNode(2, null, new TreeNode(9))), 4),
                Arguments.of(new TreeNode(1,
                        new TreeNode(3, new TreeNode(5), new TreeNode(3)),
                        null), 2),
                Arguments.of(new TreeNode(1,
                        new TreeNode(3, new TreeNode(5), null),
                        new TreeNode(2)), 2),
                Arguments.of(new TreeNode(1,
                        new TreeNode(3, new TreeNode(5, new TreeNode(6), null), null),
                        new TreeNode(2, null, new TreeNode(9, null, new TreeNode(7)))), 8)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testWidthOfBinaryTreeDfs(TreeNode root, int expected) {
        // given
        MaximumWidthOfBinaryTree solution = new MaximumWidthOfBinaryTree();

        // when
        int value = solution.widthOfBinaryTreeDfs(root);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testWidthOfBinaryTree(TreeNode root, int expected) {
        // given
        MaximumWidthOfBinaryTree solution = new MaximumWidthOfBinaryTree();

        // when
        int value = solution.widthOfBinaryTree(root);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }
}