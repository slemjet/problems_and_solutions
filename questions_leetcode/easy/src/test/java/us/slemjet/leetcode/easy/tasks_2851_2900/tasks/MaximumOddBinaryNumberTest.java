package us.slemjet.leetcode.easy.tasks_2851_2900.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumOddBinaryNumberTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("010", "001"),
                Arguments.of("0101", "1001"),
                Arguments.of("01", "01"),
                Arguments.of("00111", "11001")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, String expected) {
        // given
        MaximumOddBinaryNumber solution = new MaximumOddBinaryNumber();

        // when
        String result = solution.maximumOddBinaryNumber(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}