package us.slemjet.leetcode.medium.tasks_551_600;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class OutOfBoundaryPathsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(2, 2, 2, 0, 0, 6),
                Arguments.of(1, 3, 3, 0, 1, 12),
                Arguments.of(3, 6, 8, 0, 4, 3519),
                Arguments.of(8, 7, 16, 1, 5, 102984580)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int m, int n, int maxMove, int startRow, int startColumn, int expected) {
        // given
        OutOfBoundaryPaths solution = new OutOfBoundaryPaths();

        // when
        int result = solution.findPaths(m, n, maxMove, startRow, startColumn);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}