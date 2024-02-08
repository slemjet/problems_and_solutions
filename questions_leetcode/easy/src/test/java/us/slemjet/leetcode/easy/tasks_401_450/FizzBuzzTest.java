package us.slemjet.leetcode.easy.tasks_401_450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class FizzBuzzTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(3, Arrays.asList("1", "2", "Fizz")),
                Arguments.of(5, Arrays.asList("1", "2", "Fizz", "4", "Buzz")),
                Arguments.of(15, Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFizzBuzz(int n, List<String> expected) {
        // given
        FizzBuzz solution = new FizzBuzz();

        // when
        List<String> result = solution.fizzBuzz(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}