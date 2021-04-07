package us.slemjet.leetcode.medium.from_100_to_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static us.slemjet.leetcode.medium.from_100_to_150.ConstructBinaryTreeFromPreorderAndInorderTraversal.TreeNode;

class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // preorder = [3,9,20,15,7], inorder = [9,3,15,20,7] -> [3,9,20,null,null,15,7]
                Arguments.of(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7},
                        new TreeNode(3,
                                new TreeNode(9, null, null),
                                new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        3),
                // preorder = [-1], inorder = [-1] -> [-1]
                Arguments.of(new int[]{-1}, new int[]{-1},
                        new TreeNode(-1))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testZigzagLevelOrder(int[] preorder, int[] inorder, TreeNode expected) {
        // given
        ConstructBinaryTreeFromPreorderAndInorderTraversal solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal();

        // when
        TreeNode result = solution.buildTree(preorder, inorder);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
