package us.slemjet.leetcode.easy.tasks_1701_1750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumUnitsOnATruckTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{1, 3}, new int[]{2, 2}, new int[]{3, 1}},
                        4, 8),
                Arguments.of(new int[][]{new int[]{5, 10}, new int[]{2, 5}, new int[]{4, 7}, new int[]{3, 9}},
                        10, 91)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] boxTypes, int truckSize, int expected) {
        // given
        MaximumUnitsOnATruck solution = new MaximumUnitsOnATruck();

        // when
        int result = solution.maximumUnits(boxTypes, truckSize);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}