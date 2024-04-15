package us.slemjet.leetcode.medium.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.TreeNode;

import java.util.stream.Stream;


class SumRootToLeafNumbersTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3)), 25),
                Arguments.of(new TreeNode(4,
                        new TreeNode(9,
                                new TreeNode(5),
                                new TreeNode(1)),
                        new TreeNode(0)), 1026)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(TreeNode root, int expected) {
        // given
        SumRootToLeafNumbers solution = new SumRootToLeafNumbers();

        // when
        int result = solution.sumNumbers(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}