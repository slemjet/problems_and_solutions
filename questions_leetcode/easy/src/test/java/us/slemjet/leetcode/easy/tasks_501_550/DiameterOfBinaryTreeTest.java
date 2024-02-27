package us.slemjet.leetcode.easy.tasks_501_550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.TreeNode;

import java.util.stream.Stream;

class DiameterOfBinaryTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new TreeNode(1,
                        new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                        new TreeNode(3)), 3),
                Arguments.of(new TreeNode(1, null, new TreeNode(2)), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(TreeNode root, int expected) {
        // given
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();

        // when
        int result = solution.diameterOfBinaryTree(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}