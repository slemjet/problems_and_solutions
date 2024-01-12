package us.slemjet.leetcode.medium.tasks_351_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AndroidUnlockPatternsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, 1, 9),
                Arguments.of(1, 2, 65)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int m, int n, int expected) {
        // given
        AndroidUnlockPatterns solution = new AndroidUnlockPatterns();

        // when
        int result = solution.numberOfPatterns(m, n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}