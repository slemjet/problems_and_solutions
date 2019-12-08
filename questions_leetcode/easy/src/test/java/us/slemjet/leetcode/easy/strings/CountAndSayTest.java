package us.slemjet.leetcode.easy.strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CountAndSayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, "1"),
                Arguments.of(2, "11"),
                Arguments.of(3, "21"),
                Arguments.of(4, "1211"),
                Arguments.of(5, "111221"),
                Arguments.of(6, "312211")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void strStr(int n, String expected) {
        // given
        CountAndSay solution = new CountAndSay();

        // when
        String result = solution.countAndSay(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
