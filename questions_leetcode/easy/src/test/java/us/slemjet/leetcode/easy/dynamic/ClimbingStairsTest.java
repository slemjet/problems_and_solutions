package us.slemjet.leetcode.easy.dynamic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ClimbingStairsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(44, 1134903170)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void climbStairs(int steps, int expected) {
        // given
        ClimbingStairs solution = new ClimbingStairs();

        // when
        int ways = solution.climbStairs(steps);

        // then
        Assertions.assertThat(ways).isEqualTo(expected);
    }
}