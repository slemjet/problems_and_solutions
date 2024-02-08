package us.slemjet.leetcode.hard.tasks_301_350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BurstBalloonsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{3, 1, 5, 8}, 167),
                Arguments.of(new int[]{1, 5}, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int expected) {
        // given
        BurstBalloons solution = new BurstBalloons();

        // when
        int result = solution.maxCoins(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}