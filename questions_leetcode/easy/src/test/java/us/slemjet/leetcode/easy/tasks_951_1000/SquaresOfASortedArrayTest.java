package us.slemjet.leetcode.easy.tasks_951_1000;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SquaresOfASortedArrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{-4, -1, 0, 3, 10}, new int[]{0, 1, 9, 16, 100}),
                Arguments.of(new int[]{-7, -3, 2, 3, 11}, new int[]{4, 9, 9, 49, 121})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int[] expected) {
        // given
        SquaresOfASortedArray solution = new SquaresOfASortedArray();

        // when
        int[] result = solution.sortedSquares(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}