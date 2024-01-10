package us.slemjet.leetcode.medium.tasks_2351_2400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_2351_2400.AmountOfTimeForBinaryTreeToBeInfected.TreeNode;

import java.util.stream.Stream;

class AmountOfTimeForBinaryTreeToBeInfectedTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new TreeNode(1,
                        new TreeNode(5,
                                null,
                                new TreeNode(4,
                                        new TreeNode(9),
                                        new TreeNode(2))),
                        new TreeNode(3,
                                new TreeNode(10),
                                new TreeNode(6)
                        )
                ), 3, 4),
                Arguments.of(new TreeNode(1), 1, 0),
                Arguments.of(new TreeNode(2,
                        null,
                        new TreeNode(5)), 5, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(TreeNode root, int start, int expected) {
        // given
        AmountOfTimeForBinaryTreeToBeInfected solution = new AmountOfTimeForBinaryTreeToBeInfected();

        // when
        int result = solution.amountOfTime(root, start);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionOneTraverse(TreeNode root, int start, int expected) {
        // given
        AmountOfTimeForBinaryTreeToBeInfected solution = new AmountOfTimeForBinaryTreeToBeInfected();

        // when
        int result = solution.amountOfTimeOneTraverse(root, start);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}