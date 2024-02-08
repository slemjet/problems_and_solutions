package us.slemjet.leetcode.easy.tasks_2251_2300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Largest3SameDigitNumberInStringTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("6777133339", "777"),
                Arguments.of("2300019", "000"),
                Arguments.of("42352338", "")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String num, String expected) {
        // given
        Largest3SameDigitNumberInString solution = new Largest3SameDigitNumberInString();

        // when
        String result = solution.largestGoodInteger(num);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}