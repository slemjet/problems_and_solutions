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
                Arguments.of(58, 155, List.of(67, 78, 89, 123)),
                Arguments.of(234, 2314, List.of(234, 345, 456, 567, 678, 789, 1234)),
                Arguments.of(8511, 23553, List.of(12345, 23456)),
                Arguments.of(178546104, 812704742, List.of()),
                Arguments.of(10, 1000000000, List.of(12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345, 3456, 4567, 5678, 6789, 12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789, 1234567, 2345678, 3456789, 12345678, 23456789, 123456789))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int low, int high, List<Integer> expected) {
        // given
        SequentialDigits solution = new SequentialDigits();

        // when
        List<Integer> result = solution.sequentialDigits(low, high);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution2(int low, int high, List<Integer> expected) {
        // given
        SequentialDigits solution = new SequentialDigits();

        // when
        List<Integer> result = solution.sequentialDigits2(low, high);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution3(int low, int high, List<Integer> expected) {
        // given
        SequentialDigits solution = new SequentialDigits();

        // when
        List<Integer> result = solution.sequentialDigits3(low, high);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}