package us.slemjet.leetcode.easy.from_251_to_300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AddDigitsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(38, 2),
                Arguments.of(0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testAddDigitsMath(int num, int expected) {
        // given
        AddDigits solution = new AddDigits();

        // when
        int result = solution.addDigitsMath(num);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testAddDigits(int num, int expected) {
        // given
        AddDigits solution = new AddDigits();

        // when
        int result = solution.addDigits(num);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}