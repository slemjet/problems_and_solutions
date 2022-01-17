package us.slemjet.leetcode.hard.from_1_to_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.hard.from_1_to_50.RegularExpressionMatching;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class RegularExpressionMatchingTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of("aa", "a", false),
                of("aa", "a*", true),
                of("ab", ".*", true),
                of("aab", "c*a*b", true),
                of("mississippi", "mis*is*p*.", false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testIsMatch(String input1, String input2, boolean expected) {
        // given
        RegularExpressionMatching solution = new RegularExpressionMatching();

        // when
        boolean matches = solution.isMatch(input1, input2);

        // then
        Assertions.assertThat(matches).isEqualTo(expected);
    }
}