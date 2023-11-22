package us.slemjet.leetcode.medium.tasks_2351_2400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumAmountOfTimeToCollectGarbageTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3}, 21),
                Arguments.of(new String[]{"MMM", "PGM", "GP"}, new int[]{3, 10}, 37),
                Arguments.of(new String[]{"G","M"}, new int[]{1}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String[] garbage, int[] travel, int expected) {
        // given
        MinimumAmountOfTimeToCollectGarbage solution = new MinimumAmountOfTimeToCollectGarbage();

        // when
        int result = solution.garbageCollection(garbage, travel);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}