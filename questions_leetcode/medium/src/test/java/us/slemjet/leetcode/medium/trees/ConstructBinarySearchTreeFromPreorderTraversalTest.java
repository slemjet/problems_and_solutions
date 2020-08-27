package us.slemjet.leetcode.medium.trees;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.trees.ConstructBinarySearchTreeFromPreorderTraversal.TreeNode;

import java.util.stream.Stream;

class ConstructBinarySearchTreeFromPreorderTraversalTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{8, 5, 1, 7, 10, 12},
                        new TreeNode(8,
                                new TreeNode(5,
                                        new TreeNode(1),
                                        new TreeNode(7)),
                                new TreeNode(10,
                                        null,
                                        new TreeNode(12))
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void bstFromPreorder(int[] preorder, TreeNode expected) {
        // given
        ConstructBinarySearchTreeFromPreorderTraversal solution = new ConstructBinarySearchTreeFromPreorderTraversal();

        // when
        TreeNode result = solution.bstFromPreorder(preorder);

        // then
        Assertions.assertThat(result.val).isEqualTo(expected.val);

        Assertions.assertThat(result.left.val).isEqualTo(expected.left.val);
        Assertions.assertThat(result.left.left.val).isEqualTo(expected.left.left.val);
        Assertions.assertThat(result.left.right.val).isEqualTo(expected.left.right.val);

        Assertions.assertThat(result.right.val).isEqualTo(expected.right.val);
        Assertions.assertThat(result.right.left).isEqualTo(expected.right.left);
        Assertions.assertThat(result.right.right.val).isEqualTo(expected.right.right.val);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void bstFromPreorderBFS(int[] preorder, TreeNode expected) {
        // given
        ConstructBinarySearchTreeFromPreorderTraversal solution = new ConstructBinarySearchTreeFromPreorderTraversal();

        // when
        TreeNode result = solution.bstFromPreorderBFS(preorder);

        // then
        Assertions.assertThat(result.val).isEqualTo(expected.val);

        Assertions.assertThat(result.left.val).isEqualTo(expected.left.val);
        Assertions.assertThat(result.left.left.val).isEqualTo(expected.left.left.val);
        Assertions.assertThat(result.left.right.val).isEqualTo(expected.left.right.val);

        Assertions.assertThat(result.right.val).isEqualTo(expected.right.val);
        Assertions.assertThat(result.right.left).isEqualTo(expected.right.left);
        Assertions.assertThat(result.right.right.val).isEqualTo(expected.right.right.val);
    }
}
