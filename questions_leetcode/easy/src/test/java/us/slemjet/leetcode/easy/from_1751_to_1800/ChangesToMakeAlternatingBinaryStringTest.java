package us.slemjet.leetcode.easy.from_1751_to_1800;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ChangesToMakeAlternatingBinaryStringTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("0100", 1),
                Arguments.of("10", 0),
                Arguments.of("1111", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, int expected) {
        // given
        ChangesToMakeAlternatingBinaryString solution = new ChangesToMakeAlternatingBinaryString();

        // when
        int result = solution.minOperations(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}