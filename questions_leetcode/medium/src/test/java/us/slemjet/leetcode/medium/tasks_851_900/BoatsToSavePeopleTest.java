package us.slemjet.leetcode.medium.tasks_851_900;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BoatsToSavePeopleTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, 3, 1),
                Arguments.of(new int[]{3, 2, 2, 1}, 3, 3),
                Arguments.of(new int[]{3, 5, 3, 4}, 5, 4),
                Arguments.of(new int[]{2, 4}, 5, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testNumRescueBoats(int[] people, int limit, int expected) {
        // given
        BoatsToSavePeople solution = new BoatsToSavePeople();

        // when
        int result = solution.numRescueBoats(people, limit);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testNumRescueBoatsBucket(int[] people, int limit, int expected) {
        // given
        BoatsToSavePeople solution = new BoatsToSavePeople();

        // when
        int result = solution.numRescueBoatsBucket(people, limit);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}