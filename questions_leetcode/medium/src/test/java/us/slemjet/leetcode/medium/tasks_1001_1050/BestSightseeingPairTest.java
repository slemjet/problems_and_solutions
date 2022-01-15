package us.slemjet.leetcode.medium.tasks_1001_1050;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BestSightseeingPairTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{8, 1, 5, 2, 6}, 11),
                Arguments.of(new int[]{1, 2}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxScoreSightseeingPair(int[] values, int expected) {
        // given
        BestSightseeingPair solution = new BestSightseeingPair();

        // when
        int result = solution.maxScoreSightseeingPair(values);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxScoreSightseeingPair2(int[] values, int expected) {
        // given
        BestSightseeingPair solution = new BestSightseeingPair();

        // when
        int result = solution.maxScoreSightseeingPair2(values);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxScoreSightseeingPair3(int[] values, int expected) {
        // given
        BestSightseeingPair solution = new BestSightseeingPair();

        // when
        int result = solution.maxScoreSightseeingPair3(values);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}