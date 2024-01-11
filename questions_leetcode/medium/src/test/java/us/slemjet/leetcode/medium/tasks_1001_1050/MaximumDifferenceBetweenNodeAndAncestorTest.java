package us.slemjet.leetcode.medium.tasks_1001_1050;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_1001_1050.MaximumDifferenceBetweenNodeAndAncestor.TreeNode;

import java.util.stream.Stream;

class MaximumDifferenceBetweenNodeAndAncestorTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new TreeNode(8,
                        new TreeNode(3,
                                new TreeNode(1),
                                new TreeNode(6, new
                                        TreeNode(4), new
                                        TreeNode(7))),
                        new TreeNode(10,
                                null,
                                new TreeNode(14,
                                        new TreeNode(13),
                                        null))), 7),
                Arguments.of(new TreeNode(1,
                        null,
                        new TreeNode(2,
                                null,
                                new TreeNode(0,
                                        new TreeNode(3),
                                        null))), 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(TreeNode root, int expected) {
        // given
        MaximumDifferenceBetweenNodeAndAncestor solution = new MaximumDifferenceBetweenNodeAndAncestor();

        // when
        int result = solution.maxAncestorDiff(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}