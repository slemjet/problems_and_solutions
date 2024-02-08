package us.slemjet.leetcode.hard.tasks_401_450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FrogJumpTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 3, 5, 6, 8, 12, 17}, true),
                Arguments.of(new int[]{0, 1, 2, 3, 4, 8, 9, 11}, false),
                Arguments.of(new int[]{0, 2}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] stones, boolean expected) {
        // given
        FrogJump solution = new FrogJump();

        // when
        boolean result = solution.canCross(stones);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}