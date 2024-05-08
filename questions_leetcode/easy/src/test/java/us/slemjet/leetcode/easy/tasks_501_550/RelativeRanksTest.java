package us.slemjet.leetcode.easy.tasks_501_550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RelativeRanksTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 3, 2, 1}, new String[]{"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"}),
                Arguments.of(new int[]{10, 3, 8, 9, 4}, new String[]{"Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionStack(int[] score, String[] expected) {
        // given
        RelativeRanks solution = new RelativeRanks();

        // when
        String[] result = solution.findRelativeRanks(score);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}