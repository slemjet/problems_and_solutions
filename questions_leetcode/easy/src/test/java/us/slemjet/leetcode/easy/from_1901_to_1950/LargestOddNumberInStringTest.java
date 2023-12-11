package us.slemjet.leetcode.easy.from_1901_to_1950;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LargestOddNumberInStringTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("52", "5"),
                Arguments.of("4206", ""),
                Arguments.of("35427", "35427")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String num, String expected) {
        // given
        LargestOddNumberInString solution = new LargestOddNumberInString();

        // when
        String result = solution.largestOddNumber(num);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}