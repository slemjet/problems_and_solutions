package us.slemjet.leetcode.medium.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RectangleAreaTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(-3, 0, 3, 4, 0, -1, 9, 2, 45),
                Arguments.of(-2, -2, 2, 2, -2, -2, 2, 2, 16),
                Arguments.of(1, 0, 3, 2, 4, -1, 6, 1, 8),
                Arguments.of(-2, -2, 2, 2, 3, 3, 4, 4, 17)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testComputeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2, int expected) {
        // given
        RectangleArea solution = new RectangleArea();

        // when
        int result = solution.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}