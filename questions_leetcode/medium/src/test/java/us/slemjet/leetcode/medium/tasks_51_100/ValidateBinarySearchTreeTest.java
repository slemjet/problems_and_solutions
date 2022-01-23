package us.slemjet.leetcode.medium.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_51_100.ValidateBinarySearchTree.TreeNode;

import java.util.stream.Stream;

class ValidateBinarySearchTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new TreeNode(2, new TreeNode(1), new TreeNode(3)), true),
                Arguments.of(new TreeNode(5,
                        new TreeNode(1, null, null),
                        new TreeNode(4, new TreeNode(3), new TreeNode(6))), false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testIsValidBST(TreeNode root, boolean expected) {
        // given
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();

        // when
        boolean isValidBST = solution.isValidBST(root);

        // then
        Assertions.assertThat(isValidBST).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testIsValidBST2(TreeNode root, boolean expected) {
        // given
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();

        // when
        boolean isValidBST = solution.isValidBST2(root);

        // then
        Assertions.assertThat(isValidBST).isEqualTo(expected);
    }
}