package us.slemjet.leetcode.medium.tasks_3051_3100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximizeHappinessOfSelectedChildrenTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 2, 4),
                Arguments.of(new int[]{1, 1, 1, 1}, 2, 1),
                Arguments.of(new int[]{2, 3, 4, 5}, 1, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] happiness, int k, long expected) {
        // given
        MaximizeHappinessOfSelectedChildren solution = new MaximizeHappinessOfSelectedChildren();

        // when
        long result = solution.maximumHappinessSum(happiness, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}