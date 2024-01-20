package us.slemjet.leetcode.medium.tasks_351_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RotateFunctionTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 2, 6}, 26),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 330),
                Arguments.of(new int[]{100}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int expected) {
        // given
        RotateFunction solution = new RotateFunction();

        // when
        int result = solution.maxRotateFunction(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}