package us.slemjet.leetcode.easy.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CountPrimesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(10, 4),
                Arguments.of(499979, 41537)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void countPrimes(int input, int expected) {
        // given
        CountPrimes solution = new CountPrimes();

        // when
        int result = solution.countPrimes(input);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
