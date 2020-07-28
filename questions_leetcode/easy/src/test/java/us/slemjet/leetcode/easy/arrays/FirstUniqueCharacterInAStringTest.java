package us.slemjet.leetcode.easy.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FirstUniqueCharacterInAStringTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("", -1),
                Arguments.of("cc", -1),
                Arguments.of("leetcode", 0),
                Arguments.of("loveleetcode", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void firstUniqChar(String s, int expected) {
        // given
        FirstUniqueCharacterInAString solution = new FirstUniqueCharacterInAString();

        // when
        int result = solution.firstUniqChar(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void firstUniqChar2Pointers(String s, int expected) {
        // given
        FirstUniqueCharacterInAString solution = new FirstUniqueCharacterInAString();

        // when
        int result = solution.firstUniqChar2Pointers(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
