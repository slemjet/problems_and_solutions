package us.slemjet.leetcode.medium.from_50_to_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UniquePathsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(3, 7, 28),
                Arguments.of(3, 2, 3),
                Arguments.of(7, 3, 28),
                Arguments.of(3, 3, 6)

        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void uniquePaths(int m, int n, int expected) {
        // given
        UniquePaths solution = new UniquePaths();

        // when
        int result = solution.uniquePaths(m, n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
