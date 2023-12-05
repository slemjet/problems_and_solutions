package us.slemjet.leetcode.easy.from_1251_to_1300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumTimeVisitingAllPointsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{1, 1}, new int[]{3, 4}, new int[]{-1, 0}}, 7),
                Arguments.of(new int[][]{new int[]{3, 2}, new int[]{-2, 2}}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] points, int expected) {
        // given
        MinimumTimeVisitingAllPoints solution = new MinimumTimeVisitingAllPoints();

        // when
        int result = solution.minTimeToVisitAllPoints(points);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}