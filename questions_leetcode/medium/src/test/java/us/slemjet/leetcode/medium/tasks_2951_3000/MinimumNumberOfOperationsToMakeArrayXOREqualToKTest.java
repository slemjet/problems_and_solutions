package us.slemjet.leetcode.medium.tasks_2951_3000;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumNumberOfOperationsToMakeArrayXOREqualToKTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 3, 4}, 1, 2),
                Arguments.of(new int[]{2, 0, 2, 0}, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int k, int expected) {
        // given
        MinimumNumberOfOperationsToMakeArrayXOREqualToK solution = new MinimumNumberOfOperationsToMakeArrayXOREqualToK();

        // when
        int result = solution.minOperations(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}