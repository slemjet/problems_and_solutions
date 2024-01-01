package us.slemjet.leetcode.medium.tasks_251_300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PaintFenceTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(3, 2, 6),
                Arguments.of(1, 1, 1),
                Arguments.of(7, 2, 42),
                Arguments.of(2, 46340, 2147395600),
                Arguments.of(3, 1, 0),
                Arguments.of(3, 3, 24)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBottomUpDP(int n, int k, int expected) {
        // given
        PaintFence solution = new PaintFence();

        // when
        int result = solution.numWaysBottomUpDP(n, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionTopDownDP(int n, int k, int expected) {
        // given
        PaintFence solution = new PaintFence();

        // when
        int result = solution.numWaysTopDownDP(n, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}