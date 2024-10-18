package us.slemjet.leetcode.medium.tasks_1001_1050;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PairsOfSongsWithTotalDurationsDivisibleBy60Test {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{30, 20, 150, 100, 40}, 3),
                Arguments.of(new int[]{60, 60, 60}, 3),
                Arguments.of(new int[]{418,204,77,278,239,457,284,263,372,279,476,416,360,18}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] time, int expected) {
        // given
        PairsOfSongsWithTotalDurationsDivisibleBy60 solution = new PairsOfSongsWithTotalDurationsDivisibleBy60();

        // when
        int result = solution.numPairsDivisibleBy60(time);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}