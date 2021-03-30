package us.slemjet.leetcode.medium.from_1_to_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class LetterCombinationsOfAPhoneNumberTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("23", Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void letterCombinations(String digits, List<String> expected) {
        // given
        LetterCombinationsOfAPhoneNumber solution = new LetterCombinationsOfAPhoneNumber();

        // when
        List<String> results = solution.letterCombinations(digits);

        // then
        Assertions.assertThat(results).isEqualTo(expected);
    }
}
