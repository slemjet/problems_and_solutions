package us.slemjet.leetcode.easy.tasks_351_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RansomNoteTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("a", "b", false),
                Arguments.of("aa", "ab", false),
                Arguments.of("aa", "aab", true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void canConstruct(String ransomNote, String magazine, boolean expected) {
        // given
        RansomNote solution = new RansomNote();

        // when
        boolean result = solution.canConstruct(ransomNote, magazine);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
