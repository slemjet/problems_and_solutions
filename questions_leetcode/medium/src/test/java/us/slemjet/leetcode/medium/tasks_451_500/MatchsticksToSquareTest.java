package us.slemjet.leetcode.medium.tasks_451_500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MatchsticksToSquareTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2, 2, 2}, true),
                Arguments.of(new int[]{3, 3, 3, 3, 4}, false),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 102}, false),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 70, 70, 101, 102, 103, 102}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] matchsticks, boolean expected) {
        // given
        MatchsticksToSquare solution = new MatchsticksToSquare();

        // when
        boolean result = solution.makesquare(matchsticks);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}