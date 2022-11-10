package us.slemjet.leetcode.medium.tasks_1601_1650;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CountSortedVowelStringsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, 5),
                Arguments.of(2, 15),
                Arguments.of(33, 66045)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCountVowelStrings(int n, int expected) {
        // given
        CountSortedVowelStrings solution = new CountSortedVowelStrings();

        // when
        int result = solution.countVowelStrings(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCountVowelStringsDp(int n, int expected) {
        // given
        CountSortedVowelStrings solution = new CountSortedVowelStrings();

        // when
        int result = solution.countVowelStringsDp(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}