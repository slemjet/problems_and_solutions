package us.slemjet.leetcode.easy.from_150_to_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumberOf1BitsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // 00000000000000000000000000001011 -> 3
                Arguments.of(11, 3),
                // 00000000000000000000000010000000 -> 1
                Arguments.of(128, 1),
                // 11111111111111111111111111111101 -> 31
                Arguments.of(-2, 31)

        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testsHammingWeight(int n, int expected) {
        // given
        NumberOf1Bits solution = new NumberOf1Bits();

        // when
        int result = solution.hammingWeight(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}