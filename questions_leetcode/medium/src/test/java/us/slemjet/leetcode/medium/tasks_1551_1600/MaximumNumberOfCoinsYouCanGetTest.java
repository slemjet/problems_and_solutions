package us.slemjet.leetcode.medium.tasks_1551_1600;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumNumberOfCoinsYouCanGetTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 4, 1, 2, 7, 8}, 9),
                Arguments.of(new int[]{2, 4, 5}, 4),
                Arguments.of(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4}, 18)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] piles, int expected) {
        // given
        MaximumNumberOfCoinsYouCanGet solution = new MaximumNumberOfCoinsYouCanGet();

        // when
        int result = solution.maxCoins(piles);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}