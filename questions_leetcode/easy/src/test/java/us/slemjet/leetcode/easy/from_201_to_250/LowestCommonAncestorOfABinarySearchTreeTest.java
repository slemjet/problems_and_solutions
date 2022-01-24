package us.slemjet.leetcode.easy.from_201_to_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_201_to_250.LowestCommonAncestorOfABinarySearchTree.TreeNode;

import java.util.stream.Stream;

class LowestCommonAncestorOfABinarySearchTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8 -> Output: 6
                Arguments.of(new TreeNode(6,
                                new TreeNode(2,
                                        new TreeNode(0),
                                        new TreeNode(4, new TreeNode(3), new TreeNode(5))),
                                new TreeNode(8, new TreeNode(7), new TreeNode(9))),
                        new TreeNode(2), new TreeNode(8), new TreeNode(6)),
                // [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4 -> Output: 2
                Arguments.of(new TreeNode(6,
                                new TreeNode(2,
                                        new TreeNode(0),
                                        new TreeNode(4, new TreeNode(3), new TreeNode(5))),
                                new TreeNode(8, new TreeNode(7), new TreeNode(9))),
                        new TreeNode(2), new TreeNode(4), new TreeNode(2)),
                // [2,1], p = 2, q = 1 -> Output: 2
                Arguments.of(new TreeNode(2, new TreeNode(2), null),
                        new TreeNode(2), new TreeNode(1), new TreeNode(2))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, TreeNode expected) {
        // given
        LowestCommonAncestorOfABinarySearchTree solution = new LowestCommonAncestorOfABinarySearchTree();

        // when
        TreeNode result = solution.lowestCommonAncestor(root, p, q);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}