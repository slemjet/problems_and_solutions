package us.slemjet.leetcode.easy.tasks_1_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ReverseIntegerTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(123, 321),
                Arguments.of(-123, -321),
                Arguments.of(120, 21),
                Arguments.of(1534236469, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void reverseTest(int input, int expected) {
        // given
        ReverseInteger solution = new ReverseInteger();

        // when
        int result = solution.reverse(input);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
