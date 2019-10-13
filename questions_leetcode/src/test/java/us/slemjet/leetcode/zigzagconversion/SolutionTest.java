package us.slemjet.leetcode.zigzagconversion;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.*;

class SolutionTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                of("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
                of("PAYPALISHIRING", 5, "PHASIYIRPLIGAN"),
                of("AB", 1, "AB")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String input, int rowNums, String expected) {
        // given
        Solution solution = new Solution();

        // when
        String result = solution.convert1(input, rowNums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}