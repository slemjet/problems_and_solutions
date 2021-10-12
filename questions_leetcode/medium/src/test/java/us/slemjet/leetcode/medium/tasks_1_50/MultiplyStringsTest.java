package us.slemjet.leetcode.medium.tasks_1_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class MultiplyStringsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of("2", "3", "6"),
                of("12", "3", "36"),
                of("123", "456", "56088")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void multiplyTest(String num1, String num2, String expected) {
        // given
        MultiplyStrings solution = new MultiplyStrings();

        // when
        String result = solution.multiply(num1, num2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
