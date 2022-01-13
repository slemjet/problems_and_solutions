package us.slemjet.leetcode.medium.tasks_451_500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumNumberOfArrowsToBurstBalloonsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{10, 16}, new int[]{2, 8}, new int[]{1, 6}, new int[]{7, 12}}, 2),
                Arguments.of(new int[][]{new int[]{1, 2}, new int[]{3, 4}, new int[]{5, 6}, new int[]{7, 8}}, 4),
                Arguments.of(new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 5}}, 2),
                Arguments.of(new int[][]{new int[]{3, 9}, new int[]{7, 12}, new int[]{6, 8}, new int[]{9, 10}, new int[]{2, 9}, new int[]{0, 9}, new int[]{3, 9}, new int[]{0, 6}, new int[]{2, 8}}, 2),
                Arguments.of(new int[][]{new int[]{9, 12}, new int[]{1, 10}, new int[]{4, 11}, new int[]{8, 12}, new int[]{3, 9}, new int[]{6, 9}, new int[]{6, 7}}, 2),
                Arguments.of(new int[][]{new int[]{-2147483646, -2147483645}, new int[]{2147483646, 2147483647}}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindMinArrowShots(int[][] points, int expected) {
        // given
        MinimumNumberOfArrowsToBurstBalloons solution = new MinimumNumberOfArrowsToBurstBalloons();

        // when
        int result = solution.findMinArrowShots(points);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindMinArrowShots2(int[][] points, int expected) {
        // given
        MinimumNumberOfArrowsToBurstBalloons solution = new MinimumNumberOfArrowsToBurstBalloons();

        // when
        int result = solution.findMinArrowShots2(points);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}