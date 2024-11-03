package us.slemjet.leetcode.hard.tasks_2401_2450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumCostToMakeArrayEqualTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 2}, new int[]{2, 3, 1, 14}, 8L),
                Arguments.of(new int[]{2, 2, 2, 2, 2}, new int[]{4, 2, 8, 1, 3}, 0L),
                Arguments.of(new int[]{735103, 366367, 132236, 133334, 808160, 113001, 49051, 735598, 686615, 665317, 999793, 426087, 587000, 649989, 509946, 743518},
                        new int[]{724182, 447415, 723725, 902336, 600863, 287644, 13836, 665183, 448859, 917248, 397790, 898215, 790754, 320604, 468575, 825614}, 1907611126748L)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int[] cost, long expected) {
        // given
        MinimumCostToMakeArrayEqual solution = new MinimumCostToMakeArrayEqual();

        // when
        long result = solution.minCost(nums, cost);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}