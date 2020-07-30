package us.slemjet.leetcode.medium.strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class RemoveKDigitsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of("1432219", 3, "1219"),
                of("10200", 1, "200"),
                of("10", 2, "0"),
                of("112", 1, "11"),
                of("9", 1, "0"),
                of("1234567890", 9, "0")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void multiplyTest(String num, int k, String expected) {
        // given
        RemoveKDigits solution = new RemoveKDigits();

        // when
        String result = solution.removeKdigits(num, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
