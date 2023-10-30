package us.slemjet.leetcode.medium.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static us.slemjet.leetcode.medium.tasks_101_150.ConstructBinaryTreeFromInorderAndPostorderTraversal.TreeNode;

class ConstructBinaryTreeFromInorderAndPostorderTraversalTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // inorder = [9,3,15,20,7], postorder = [9,15,7,20,3] -> [3,9,20,null,null,15,7]
                Arguments.of(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3},
                        new TreeNode(3,
                                new TreeNode(9, null, null),
                                new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        3),
                // inorder = [1,2,3,4,5], postorder = [1,4,5,3,2] -> [2,1,3,null,null,null,5,4]
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 4, 5, 3, 2},
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                new TreeNode(3, null,
                                        new TreeNode(5, new TreeNode(4), null))),
                        3),
                // inorder = [-1], postorder = [-1] -> [-1]
                Arguments.of(new int[]{-1}, new int[]{-1},
                        new TreeNode(-1))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testZigzagLevelOrder(int[] preorder, int[] inorder, TreeNode expected) {
        // given
        ConstructBinaryTreeFromInorderAndPostorderTraversal solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal();

        // when
        TreeNode result = solution.buildTree(preorder, inorder);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}