package us.slemjet.leetcode.easy.tasks_51_100;

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
    void testClimbStairsTopToBottom(int steps, int expected) {
        // given
        ClimbingStairs solution = new ClimbingStairs();

        // when
        int ways = solution.climbStairsTopToBottom(steps);

        // then
        Assertions.assertThat(ways).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testClimbStairsBottomUp(int steps, int expected) {
        // given
        ClimbingStairs solution = new ClimbingStairs();

        // when
        int ways = solution.climbStairsBottomUp(steps);

        // then
        Assertions.assertThat(ways).isEqualTo(expected);
    }
}
