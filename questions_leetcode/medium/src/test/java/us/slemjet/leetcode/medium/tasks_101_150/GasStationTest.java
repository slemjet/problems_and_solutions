package us.slemjet.leetcode.medium.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class GasStationTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}, 3),
                Arguments.of(new int[]{2, 3, 4}, new int[]{3, 4, 3}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCanCompleteCircuit(int[] gas, int[] cost, int expected) {
        // given
        GasStation solution = new GasStation();

        // when
        int result = solution.canCompleteCircuit(gas, cost);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
