package us.slemjet.leetcode.medium.tasks_1451_1500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_1451_1500.PseudoPalindromicPathsInABinaryTree.TreeNode;

import java.util.stream.Stream;

class PseudoPalindromicPathsInABinaryTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(3),
                                new TreeNode(1)),
                        new TreeNode(1,
                                null,
                                new TreeNode(1))), 2),
                Arguments.of(new TreeNode(2,
                        new TreeNode(1,
                                new TreeNode(1),
                                new TreeNode(3,
                                        null,
                                        new TreeNode(1))),
                        new TreeNode(1)), 1),
                Arguments.of(new TreeNode(9), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(TreeNode root, int expected) {
        // given
        PseudoPalindromicPathsInABinaryTree solution = new PseudoPalindromicPathsInABinaryTree();

        // when
        int result = solution.pseudoPalindromicPaths(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}