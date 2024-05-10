package us.slemjet.leetcode.medium.tasks_751_800;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class KthSmallestPrimeFractionTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 5}, 3, new int[]{2, 5}),
                Arguments.of(new int[]{1, 7}, 1, new int[]{1, 7}),
                Arguments.of(new int[]{1, 5, 17, 29, 41, 43, 61, 73, 83}, 21, new int[]{29, 73})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] arr, int k, int[] expected) {
        // given
        KthSmallestPrimeFraction solution = new KthSmallestPrimeFraction();

        // when
        int[] result = solution.kthSmallestPrimeFraction(arr, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}