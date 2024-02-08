package us.slemjet.leetcode.easy.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.tasks_101_150.SymmetricTree.TreeNode;

import java.util.stream.Stream;

class SymmetricTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // [1,2,2,null,3,null,3] -> false
                Arguments.of(
                        new TreeNode(1,
                                new TreeNode(2, null, new TreeNode(3)),
                                new TreeNode(2, null, new TreeNode(3))), false),
                // [1,2,2,3,4,4,3] -> true
                Arguments.of(
                        new TreeNode(1,
                                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                                new TreeNode(2, new TreeNode(4), new TreeNode(3))), true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(TreeNode root, boolean expected) {
        // given
        SymmetricTree solution = new SymmetricTree();

        // when
        boolean result = solution.isSymmetric(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
