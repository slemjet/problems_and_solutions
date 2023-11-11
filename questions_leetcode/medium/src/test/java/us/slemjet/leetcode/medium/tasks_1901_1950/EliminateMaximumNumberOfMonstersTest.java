package us.slemjet.leetcode.medium.tasks_1901_1950;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class EliminateMaximumNumberOfMonstersTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 4}, new int[]{1, 1, 1}, 3),
                Arguments.of(new int[]{1, 1, 2, 3}, new int[]{1, 1, 1, 1}, 1),
                Arguments.of(new int[]{3, 2, 4}, new int[]{5, 3, 2}, 1),
                Arguments.of(new int[]{3, 5, 7, 4, 5}, new int[]{2, 3, 6, 3, 2}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testEliminateMaximum(int[] dist, int[] speed, int expected) {
        // given
        EliminateMaximumNumberOfMonsters solution = new EliminateMaximumNumberOfMonsters();

        // when
        int result = solution.eliminateMaximum(dist, speed);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}