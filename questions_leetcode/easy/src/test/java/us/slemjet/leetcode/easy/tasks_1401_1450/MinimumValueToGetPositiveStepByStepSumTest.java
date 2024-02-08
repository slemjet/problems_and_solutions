package us.slemjet.leetcode.easy.tasks_1401_1450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumValueToGetPositiveStepByStepSumTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{-3, 2, -3, 4, 2}, 5),
                Arguments.of(new int[]{1, 2}, 1),
                Arguments.of(new int[]{1, -2, -3}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinStartValue(int[] nums, int expected) {
        // given
        MinimumValueToGetPositiveStepByStepSum solution = new MinimumValueToGetPositiveStepByStepSum();

        // when
        int result = solution.minStartValue(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}