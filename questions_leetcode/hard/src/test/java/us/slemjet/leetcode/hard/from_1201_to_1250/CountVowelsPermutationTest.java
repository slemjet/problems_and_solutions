package us.slemjet.leetcode.hard.from_1201_to_1250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.hard.from_1201_to_1250.CountVowelsPermutation;

import java.util.stream.Stream;

class CountVowelsPermutationTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, 5),
                Arguments.of(2, 10),
                Arguments.of(5, 68),
                Arguments.of(144, 18208803),
                Arguments.of(158, 237753473)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCountVowelPermutation(int n, int expected) {
        // given
        CountVowelsPermutation solution = new CountVowelsPermutation();

        // when
        int result = solution.countVowelPermutation(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}