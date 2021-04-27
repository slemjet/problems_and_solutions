package us.slemjet.leetcode.hard.from_100_to_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.hard.from_100_to_150.BinaryTreeMaximumPathSum.TreeNode;

import java.util.stream.Stream;

class BinaryTreeMaximumPathSumTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // [-3] -> -3
                Arguments.of(new TreeNode(-3, null, null), -3),
                // [1,2] -> 3
                Arguments.of(new TreeNode(1, new TreeNode(2), null), 3),
                // [2,-1] -> 2
                Arguments.of(new TreeNode(2, new TreeNode(-1), null), 2),
                // [1,-2,3] -> 4
                Arguments.of(new TreeNode(1, new TreeNode(-2), new TreeNode(3)), 4),
                // [1,2,3] -> 6
                Arguments.of(
                        new TreeNode(1,
                                new TreeNode(2, null, null),
                                new TreeNode(3, null, null)), 6),
                // [-10,9,20,null,null,15,7] -> 42
                Arguments.of(
                        new TreeNode(-10,
                                new TreeNode(9, null, null),
                                new TreeNode(20, new TreeNode(15), new TreeNode(7))), 42),
                // [1,-2,-3,1,3,-2,null,-1] -> 3
                Arguments.of(
                        new TreeNode(1,
                                new TreeNode(-2, new TreeNode(1), new TreeNode(3)),
                                new TreeNode(-3, new TreeNode(-2), null)), 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(TreeNode root, int expected) {
        // given
        BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();

        // when
        int result = solution.maxPathSum(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
