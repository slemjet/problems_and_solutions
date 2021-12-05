package us.slemjet.leetcode.medium.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_201_250.LowestCommonAncestorOfABinaryTree.TreeNode;

import java.util.stream.Stream;

class LowestCommonAncestorOfABinaryTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 -> 3
                Arguments.of(
                        new TreeNode(3,
                                new TreeNode(5,
                                        new TreeNode(6),
                                        new TreeNode(2,
                                                new TreeNode(7),
                                                new TreeNode(4))),
                                new TreeNode(1,
                                        new TreeNode(0),
                                        new TreeNode(8))),
                        new TreeNode(5),
                        new TreeNode(1),
                        new TreeNode(3)),
                // [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4 - > 5
                Arguments.of(
                        new TreeNode(3,
                                new TreeNode(5,
                                        new TreeNode(6),
                                        new TreeNode(2,
                                                new TreeNode(7),
                                                new TreeNode(4))),
                                new TreeNode(1,
                                        new TreeNode(0),
                                        new TreeNode(8))),
                        new TreeNode(5),
                        new TreeNode(4),
                        new TreeNode(5)),
                // [1,2], p = 1, q = 2 -> 1
                Arguments.of(
                        new TreeNode(1,
                                new TreeNode(2), null),
                        new TreeNode(1),
                        new TreeNode(2),
                        new TreeNode(1))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, TreeNode expected) {
        // given
        LowestCommonAncestorOfABinaryTree solution = new LowestCommonAncestorOfABinaryTree();

        // when
        TreeNode result = solution.lowestCommonAncestor(root, p, q);

        // then
        Assertions.assertThat(result.val).isEqualTo(expected.val);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q, TreeNode expected) {
        // given
        LowestCommonAncestorOfABinaryTree solution = new LowestCommonAncestorOfABinaryTree();

        // when
        TreeNode result = solution.lowestCommonAncestor2(root, p, q);

        // then
        Assertions.assertThat(result.val).isEqualTo(expected.val);
    }
}