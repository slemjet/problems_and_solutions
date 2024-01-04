package us.slemjet.leetcode.medium.tasks_301_350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SuperUglyNumberTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(12, new int[]{2, 7, 13, 19}, 32),
                Arguments.of(1, new int[]{2, 3, 5}, 1),
                Arguments.of(5911, new int[]{2, 3, 5, 7}, 2144153025)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, int[] primes, int expected) {
        // given
        SuperUglyNumber solution = new SuperUglyNumber();

        // when
        int result = solution.nthSuperUglyNumber(n, primes);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionI(int n, int[] primes, int expected) {
        // given
        SuperUglyNumber solution = new SuperUglyNumber();

        // when
        int result = solution.nthSuperUglyNumberI(n, primes);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}