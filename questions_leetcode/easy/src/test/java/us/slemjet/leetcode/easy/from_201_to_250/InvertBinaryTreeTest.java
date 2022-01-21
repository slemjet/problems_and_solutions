package us.slemjet.leetcode.easy.from_201_to_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_201_to_250.InvertBinaryTree.TreeNode;

import java.util.stream.Stream;

class InvertBinaryTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(4,
                                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                                new TreeNode(7, new TreeNode(6), new TreeNode(7))),
                        new TreeNode(4,
                                new TreeNode(7, new TreeNode(7), new TreeNode(6)),
                                new TreeNode(2, new TreeNode(3), new TreeNode(1)))),
                Arguments.of(
                        new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                        new TreeNode(2, new TreeNode(3), new TreeNode(1)))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testInvertTree(TreeNode root, TreeNode expected) {
        // given
        InvertBinaryTree solution = new InvertBinaryTree();

        // when
        TreeNode result = solution.invertTree(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}