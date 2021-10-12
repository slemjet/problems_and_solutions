package us.slemjet.leetcode.medium.tasks_1_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ZigZagConversionTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                Arguments.of("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
                Arguments.of("PAYPALISHIRING", 5, "PHASIYIRPLIGAN"),
                Arguments.of("AB", 1, "AB")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution1(String input, int rowNums, String expected) {
        // given
        ZigZagConversion solution = new ZigZagConversion();

        // when
        String result = solution.convert1(input, rowNums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution2(String input, int rowNums, String expected) {
        // given
        ZigZagConversion solution = new ZigZagConversion();

        // when
        String result = solution.convert2(input, rowNums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
