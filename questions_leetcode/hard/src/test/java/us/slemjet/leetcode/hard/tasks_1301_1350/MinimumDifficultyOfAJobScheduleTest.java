package us.slemjet.leetcode.hard.tasks_1301_1350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumDifficultyOfAJobScheduleTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{6, 5, 4, 3, 2, 1}, 2, 7),
                Arguments.of(new int[]{9, 9, 9}, 4, -1),
                Arguments.of(new int[]{1, 1, 1}, 3, 3),
                Arguments.of(new int[]{7, 1, 7, 1, 7, 1}, 3, 15),
                Arguments.of(new int[]{11, 111, 22, 222, 33, 333, 44, 444}, 6, 843)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinDifficultyTopDown(int[] jobDifficulty, int d, int expected) {
        // given
        MinimumDifficultyOfAJobSchedule solution = new MinimumDifficultyOfAJobSchedule();

        // when
        int result = solution.minDifficultyTopDown(jobDifficulty, d);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinDifficultyBottomUp(int[] jobDifficulty, int d, int expected) {
        // given
        MinimumDifficultyOfAJobSchedule solution = new MinimumDifficultyOfAJobSchedule();

        // when
        int result = solution.minDifficultyBottomUp(jobDifficulty, d);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}