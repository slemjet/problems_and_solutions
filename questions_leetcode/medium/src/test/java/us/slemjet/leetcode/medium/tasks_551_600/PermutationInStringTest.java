package us.slemjet.leetcode.medium.tasks_551_600;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_551_600.PermutationInString;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class PermutationInStringTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of("ab", "eidbaooo", true),
                of("ab", "eidboaoo", false),
                of("adc", "dcda", true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void checkInclusion(String s1, String s2, boolean expected) {
        // given
        PermutationInString solution = new PermutationInString();

        // when
        boolean result = solution.checkInclusion(s1, s2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
