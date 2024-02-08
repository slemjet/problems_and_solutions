package us.slemjet.leetcode.hard.tasks_351_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RussianDollEnvelopesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{5, 4}, new int[]{6, 4}, new int[]{6, 7}, new int[]{2, 3}}, 3),
                Arguments.of(new int[][]{new int[]{1, 1}, new int[]{1, 1}, new int[]{1, 1}}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] envelopes, int expected) {
        // given
        RussianDollEnvelopes solution = new RussianDollEnvelopes();

        // when
        int result = solution.maxEnvelopes(envelopes);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}