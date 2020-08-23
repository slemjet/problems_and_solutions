package us.slemjet.leetcode.easy.tree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.tree.CousinsInBinaryTree.TreeNode;

import java.util.stream.Stream;

class CousinsInBinaryTreeTest {
    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(1,
                                new TreeNode(2,
                                        new TreeNode(4),
                                        null),
                                new TreeNode(3)
                        ), 4, 3, false),
                Arguments.of(
                        new TreeNode(1,
                                new TreeNode(2,
                                        new TreeNode(4),
                                        null),
                                new TreeNode(3,
                                        new TreeNode(5),
                                        null)
                        ), 5, 4, true),
                Arguments.of(
                        new TreeNode(1,
                                new TreeNode(2,
                                        null,
                                        new TreeNode(4)),
                                new TreeNode(3)
                        ), 4, 3, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void isCousins(TreeNode root, int x, int y, boolean expected) {
        // given
        CousinsInBinaryTree solution = new CousinsInBinaryTree();

        // when
        boolean result = solution.isCousins(root, x, y);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void isCousinsDelimiter(TreeNode root, int x, int y, boolean expected) {
        // given
        CousinsInBinaryTree solution = new CousinsInBinaryTree();

        // when
        boolean result = solution.isCousinsDelimiter(root, x, y);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
