package us.slemjet.leetcode.hard.from_50_to_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class LargestRectangleInHistogramTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{2, 1, 5, 6, 2, 3}, 10),
                of(new int[]{2, 4}, 4),
                of(new int[]{2, 1, 2}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLargestRectangleAreaDynamic(int[] heights, int expected) {
        // given
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();

        // when
        int result = solution.largestRectangleAreaDynamic(heights);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLargestRectangleAreaStack(int[] heights, int expected) {
        // given
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();

        // when
        int result = solution.largestRectangleAreaStack(heights);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLargestRectangleArea(int[] heights, int expected) {
        // given
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();

        // when
        int result = solution.largestRectangleArea(heights);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
