package us.slemjet.leetcode.easy.tasks_2101_2150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FindFirstPalindromicStringInTheArrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"abc", "car", "ada", "racecar", "cool"}, "ada"),
                Arguments.of(new String[]{"notapalindrome", "racecar"}, "racecar"),
                Arguments.of(new String[]{"def", "ghi"}, "")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String[] words, String expected) {
        // given
        FindFirstPalindromicStringInTheArray solution = new FindFirstPalindromicStringInTheArray();

        // when
        String result = solution.firstPalindrome(words);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}