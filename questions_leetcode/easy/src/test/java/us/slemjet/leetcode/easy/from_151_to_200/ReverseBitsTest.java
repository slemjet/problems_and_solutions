package us.slemjet.leetcode.easy.from_151_to_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ReverseBitsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // 00000010100101000001111010011100 -> 00111001011110000010100101000000
                // 43261596 -> 964176192
                Arguments.of(43261596, 964176192),
                // 11111111111111111111111111111101 -> 10111111111111111111111111111111
                // 4294967293 -> 3221225471
                Arguments.of(-3, -1073741825)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testsReverseBits(int n, int expected) {
        // given
        ReverseBits solution = new ReverseBits();

        // when
        int result = solution.reverseBits(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}