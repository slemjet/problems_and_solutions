package us.slemjet.leetcode.medium.tasks_151_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LargestNumberTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{999999991, 9}, "9999999991"),
                Arguments.of(new int[]{10, 2}, "210"),
                Arguments.of(new int[]{3, 30, 34, 5, 9}, "9534330"),
                Arguments.of(new int[]{1}, "1"),
                Arguments.of(new int[]{10}, "10"),
                Arguments.of(new int[]{0, 0}, "0")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testsLargestNumber(int[] nums, String expected) {
        // given
        LargestNumber solution = new LargestNumber();

        // when
        String result = solution.largestNumber(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}