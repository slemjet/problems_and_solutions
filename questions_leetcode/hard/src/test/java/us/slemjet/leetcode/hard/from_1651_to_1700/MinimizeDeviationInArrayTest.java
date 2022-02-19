package us.slemjet.leetcode.hard.from_1651_to_1700;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class MinimizeDeviationInArrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{1, 2, 3, 4}, 1),
                of(new int[]{4, 1, 5, 20, 3}, 3),
                of(new int[]{2, 10, 8}, 3),
                of(new int[]{3, 5}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinimumDeviation(int[] nums, int expected) {
        // given
        MinimizeDeviationInArray solution = new MinimizeDeviationInArray();

        // when
        int result = solution.minimumDeviation(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinimumDeviationTreeSet(int[] nums, int expected) {
        // given
        MinimizeDeviationInArray solution = new MinimizeDeviationInArray();

        // when
        int result = solution.minimumDeviationTreeSet(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}