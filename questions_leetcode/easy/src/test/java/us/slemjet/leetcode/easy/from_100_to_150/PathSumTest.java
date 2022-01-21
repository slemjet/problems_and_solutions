package us.slemjet.leetcode.easy.from_100_to_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_100_to_150.PathSum.TreeNode;

import java.util.stream.Stream;

class PathSumTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(5,
                                new TreeNode(4,
                                        new TreeNode(11,
                                                new TreeNode(7),
                                                new TreeNode(2)),
                                        null),
                                new TreeNode(8,
                                        new TreeNode(13),
                                        new TreeNode(4,
                                                null,
                                                new TreeNode(1)))),
                        22, true),
                Arguments.of(
                        new TreeNode(1,
                                new TreeNode(2),
                                new TreeNode(3)),
                        5, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testHasPathSum(TreeNode root, int targetSum, boolean expected) {
        // given
        PathSum solution = new PathSum();

        // when
        boolean result = solution.hasPathSum(root, targetSum);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testHasPathSum2(TreeNode root, int targetSum, boolean expected) {
        // given
        PathSum solution = new PathSum();

        // when
        boolean result = solution.hasPathSum2(root, targetSum);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}