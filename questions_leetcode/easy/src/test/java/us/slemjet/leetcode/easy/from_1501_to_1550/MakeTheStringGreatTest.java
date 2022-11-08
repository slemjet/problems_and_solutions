package us.slemjet.leetcode.easy.from_1501_to_1550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MakeTheStringGreatTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("leEeetcode", "leetcode"),
                Arguments.of("abBAcC", ""),
                Arguments.of("s", "s")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMakeGood(String s, String expected) {
        // given
        MakeTheStringGreat solution = new MakeTheStringGreat();

        // when
        String result = solution.makeGood(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}