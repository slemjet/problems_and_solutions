package us.slemjet.leetcode.medium.tasks_401_450.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ArithmeticSlicesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 3),
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{1, 2, 3, 8, 9, 10}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testNumberOfArithmeticSlices(int[] nums, int expected) {
        // given
        ArithmeticSlices solution = new ArithmeticSlices();

        // when
        int result = solution.numberOfArithmeticSlices(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testNumberOfArithmeticSlices2(int[] nums, int expected) {
        // given
        ArithmeticSlices solution = new ArithmeticSlices();

        // when
        int result = solution.numberOfArithmeticSlices2(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}