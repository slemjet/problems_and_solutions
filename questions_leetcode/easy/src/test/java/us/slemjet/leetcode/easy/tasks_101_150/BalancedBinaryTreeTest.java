package us.slemjet.leetcode.easy.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static us.slemjet.leetcode.easy.tasks_101_150.BalancedBinaryTree.TreeNode;

class BalancedBinaryTreeTest {

    private static Stream<Arguments> parameters2Pointers() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(3,
                                new TreeNode(9),
                                new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        true),
                Arguments.of(new TreeNode(1,
                                new TreeNode(2,
                                        new TreeNode(3,
                                                new TreeNode(4),
                                                new TreeNode(4)),
                                        new TreeNode(3)),
                                new TreeNode(2)),
                        false),
                Arguments.of(new TreeNode(),
                        true),
                // [1,null,2,null,3]
                Arguments.of(new TreeNode(1,
                                null,
                                new TreeNode(2, null, new TreeNode(3))),
                        false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters2Pointers")
    void testIsBalanced(TreeNode head, boolean expected) {
        // given
        BalancedBinaryTree solution = new BalancedBinaryTree();

        // when
        boolean result = solution.isBalanced(head);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}