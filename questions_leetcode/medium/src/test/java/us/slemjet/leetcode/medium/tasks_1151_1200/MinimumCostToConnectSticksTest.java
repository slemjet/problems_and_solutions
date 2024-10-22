package us.slemjet.leetcode.medium.tasks_1151_1200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumCostToConnectSticksTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 4, 3}, 14),
                Arguments.of(new int[]{1, 8, 3, 5}, 30),
                Arguments.of(new int[]{5}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] sticks, int expected) {
        // given
        MinimumCostToConnectSticks solution = new MinimumCostToConnectSticks();

        // when
        int result = solution.connectSticks(sticks);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}