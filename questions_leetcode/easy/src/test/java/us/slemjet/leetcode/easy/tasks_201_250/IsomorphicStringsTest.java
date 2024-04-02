package us.slemjet.leetcode.easy.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class IsomorphicStringsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of("egg", "add", true),
                of("foo", "bar", false),
                of("paper", "title", true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, String t, boolean expected) {
        // given
        IsomorphicStrings solution = new IsomorphicStrings();

        // when
        boolean result = solution.isIsomorphic(s, t);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}