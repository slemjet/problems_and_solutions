package us.slemjet.leetcode.medium.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SortColorsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 0, 2, 1, 1, 0}, new int[]{0, 0, 1, 1, 2, 2}),
                Arguments.of(new int[]{2, 0, 1}, new int[]{0, 1, 2}),
                Arguments.of(new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{1}, new int[]{1})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void sortColors(int[] nums, int[] expected) {
        // given
        SortColors solution = new SortColors();

        // when
        solution.sortColors(nums);

        // then
        Assertions.assertThat(nums).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void sortColors2(int[] nums, int[] expected) {
        // given
        SortColors solution = new SortColors();

        // when
        solution.sortColors2(nums);

        // then
        Assertions.assertThat(nums).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void sortColors3(int[] nums, int[] expected) {
        // given
        SortColors solution = new SortColors();

        // when
        solution.sortColors3(nums);

        // then
        Assertions.assertThat(nums).isEqualTo(expected);
    }
}
