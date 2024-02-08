package us.slemjet.leetcode.hard.tasks_1051_1100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumberOfSubmatricesThatSumToTargetTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{0, 1, 0},
                        new int[]{1, 1, 1},
                        new int[]{0, 1, 0}}, 0, 4),
                Arguments.of(new int[][]{
                        new int[]{1, -1},
                        new int[]{-1, 1}}, 0, 5),
                Arguments.of(new int[][]{
                        new int[]{904}}, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionSimulation(int[][] matrix, int target, int expected) {
        // given
        NumberOfSubmatricesThatSumToTarget solution = new NumberOfSubmatricesThatSumToTarget();

        // when
        int result = solution.numSubmatrixSumTarget(matrix, target);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}