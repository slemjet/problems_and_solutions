package us.slemjet.leetcode.easy.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ValidAnagramTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("anagram", "nagaram", true),
                Arguments.of("rat", "car", false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testIsAnagram(String s, String t, boolean expected) {
        // given
        ValidAnagram solution = new ValidAnagram();

        // when
        boolean result = solution.isAnagram(s, t);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}