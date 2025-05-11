package us.slemjet.hackerrank.questions.warmup;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TimeConversionTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("12:01:00PM", "12:01:00"),
                Arguments.of("12:01:00AM", "00:01:00"),
                Arguments.of("07:05:45PM", "19:05:45")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(String s, String expected) {

        // given
        TimeConversion solution = new TimeConversion();

        // when
        String result = solution.timeConversion(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}