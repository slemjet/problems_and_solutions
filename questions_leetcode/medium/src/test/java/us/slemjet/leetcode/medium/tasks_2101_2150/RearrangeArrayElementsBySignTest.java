package us.slemjet.leetcode.medium.tasks_2101_2150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_2101_2150.RearrangeArrayElementsBySign;

import java.util.stream.Stream;

class RearrangeArrayElementsBySignTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{3, 1, -2, -5, 2, -4}, new int[]{3, -2, 1, -5, 2, -4}),
                Arguments.of(new int[]{-1, 1}, new int[]{1, -1})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int[] expected) {
        // given
        RearrangeArrayElementsBySign solution = new RearrangeArrayElementsBySign();

        // when
        int[] result = solution.rearrangeArray(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution2(int[] nums, int[] expected) {
        // given
        RearrangeArrayElementsBySign solution = new RearrangeArrayElementsBySign();

        // when
        int[] result = solution.rearrangeArray2(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}