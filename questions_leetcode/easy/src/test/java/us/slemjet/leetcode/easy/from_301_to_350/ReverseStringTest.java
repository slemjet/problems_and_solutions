package us.slemjet.leetcode.easy.from_301_to_350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new char[]{'h','e','l','l','o'}, new char[]{'o','l','l','e','h'}),
                Arguments.of(new char[]{'H','a','n','n','a','h'}, new char[]{'h','a','n','n','a','H'})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testReverseString(char[] s, char[] expected) {
        // given
        ReverseString solution = new ReverseString();

        // when
        solution.reverseString(s);

        // then
        Assertions.assertThat(s).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testReverseStringTmp(char[] s, char[] expected) {
        // given
        ReverseString solution = new ReverseString();

        // when
        solution.reverseStringTmp(s);

        // then
        Assertions.assertThat(s).isEqualTo(expected);
    }

}