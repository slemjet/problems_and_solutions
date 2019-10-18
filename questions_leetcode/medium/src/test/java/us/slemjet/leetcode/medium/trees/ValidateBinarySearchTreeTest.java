package us.slemjet.leetcode.medium.trees;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.trees.ValidateBinarySearchTree.TreeNode;

import java.util.stream.Stream;

class ValidateBinarySearchTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new Integer[]{2, 1, 3}, true),
                Arguments.of(new Integer[]{5, 1, 4, null, null, 3, 6}, false),
                Arguments.of(new Integer[]{1, 1}, false),
                Arguments.of(new Integer[]{10, 5, 15, null, null, 6, 20}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(Integer[] input, boolean expected) {
        // given
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
        TreeNode tree = new TreeNode(input[0]);
        if (input.length > 1 && input[1] != null)
            tree.left = new TreeNode(input[1]);
        if (input.length > 2 && input[2] != null)
            tree.right = new TreeNode(input[2]);
        if (input.length > 3 && input[3] != null)
            tree.left.left = new TreeNode(input[3]);
        if (input.length > 4 && input[4] != null)
            tree.left.right = new TreeNode(input[4]);
        if (input.length > 5 && input[5] != null)
            tree.right.left = new TreeNode(input[5]);
        if (input.length > 6 && input[6] != null)
            tree.right.right = new TreeNode(input[6]);

        // when
        Boolean isValidBST = solution.isValidBST(tree);

        // then
        Assertions.assertThat(isValidBST).isEqualTo(expected);
    }
}