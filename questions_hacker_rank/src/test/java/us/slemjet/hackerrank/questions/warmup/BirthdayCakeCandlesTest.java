package us.slemjet.hackerrank.questions.warmup;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class BirthdayCakeCandlesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(4, 4, 1, 3), 2),
                Arguments.of(List.of(3, 2, 1, 3), 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(List<Integer> candles, int n) {

        // given
        BirthdayCakeCandles solution = new BirthdayCakeCandles();

        // when
        int result = solution.birthdayCakeCandles(candles);

        // then
        Assertions.assertThat(result).isEqualTo(n);
    }
}