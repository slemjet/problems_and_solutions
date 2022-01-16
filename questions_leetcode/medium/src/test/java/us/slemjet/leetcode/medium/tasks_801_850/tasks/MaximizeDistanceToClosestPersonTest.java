package us.slemjet.leetcode.medium.tasks_801_850.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximizeDistanceToClosestPersonTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 0, 0, 0, 1, 0, 1}, 2),
                Arguments.of(new int[]{1, 0, 0, 0}, 3),
                Arguments.of(new int[]{0, 1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxDistToClosest(int[] seats, int expected) {
        // given
        MaximizeDistanceToClosestPerson solution = new MaximizeDistanceToClosestPerson();

        // when
        int result = solution.maxDistToClosest(seats);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}