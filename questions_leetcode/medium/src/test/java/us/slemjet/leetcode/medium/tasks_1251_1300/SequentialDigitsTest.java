package us.slemjet.leetcode.medium.tasks_1251_1300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SequentialDigitsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(100, 300, List.of(123, 234)),
                Arguments.of(1000, 13000, List.of(1234, 2345, 3456, 4567, 5678, 6789, 12345)),
                Arguments.of(58, 155, List.of(67, 78, 89, 123))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSequentialDigits(int low, int high, List<Integer> expected) {
        // given
        SequentialDigits solution = new SequentialDigits();

        // when
        List<Integer> result = solution.sequentialDigits(low, high);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSequentialDigits2(int low, int high, List<Integer> expected) {
        // given
        SequentialDigits solution = new SequentialDigits();

        // when
        List<Integer> result = solution.sequentialDigits2(low, high);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}