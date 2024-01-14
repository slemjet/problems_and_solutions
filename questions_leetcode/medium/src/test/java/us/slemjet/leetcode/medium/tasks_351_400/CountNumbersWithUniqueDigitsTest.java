package us.slemjet.leetcode.medium.tasks_351_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_451_500.PredictTheWinner;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CountNumbersWithUniqueDigitsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 10),
                Arguments.of(2, 91)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionTopDown(int n, int expected) {
        // given
        CountNumbersWithUniqueDigits solution = new CountNumbersWithUniqueDigits();

        // when
        int result = solution.countNumbersWithUniqueDigits(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}