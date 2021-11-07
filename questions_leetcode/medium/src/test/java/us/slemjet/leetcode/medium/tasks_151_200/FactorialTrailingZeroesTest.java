package us.slemjet.leetcode.medium.tasks_151_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FactorialTrailingZeroesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(3, 0),
                Arguments.of(5, 1),
                Arguments.of(0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testsTrailingZeroes(int n, int expected) {
        // given
        FactorialTrailingZeroes solution = new FactorialTrailingZeroes();

        // when
        int result = solution.trailingZeroes(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}