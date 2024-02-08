package us.slemjet.leetcode.hard.tasks_50_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NQueensIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(4, 2),
                Arguments.of(1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, int expected) {
        // given
        NQueensII solution = new NQueensII();

        // when
        int result = solution.totalNQueens(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}