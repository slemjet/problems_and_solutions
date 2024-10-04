package us.slemjet.leetcode.medium.tasks_2451_2500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DividePlayersIntoTeamsOfEqualSkillTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 5, 1, 3, 4}, 22),
                Arguments.of(new int[]{3, 4}, 12),
                Arguments.of(new int[]{1, 1, 2, 3}, -1),
                Arguments.of(new int[]{1, 1000}, 1000)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionSorting(int[] skill, long expected) {
        // given
        DividePlayersIntoTeamsOfEqualSkill solution = new DividePlayersIntoTeamsOfEqualSkill();

        // when
        long result = solution.dividePlayersSorting(skill);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBucket(int[] skill, long expected) {
        // given
        DividePlayersIntoTeamsOfEqualSkill solution = new DividePlayersIntoTeamsOfEqualSkill();

        // when
        long result = solution.dividePlayersBucket(skill);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}