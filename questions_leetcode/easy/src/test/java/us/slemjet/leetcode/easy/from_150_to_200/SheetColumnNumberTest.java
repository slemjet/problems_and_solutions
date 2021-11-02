package us.slemjet.leetcode.easy.from_150_to_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SheetColumnNumberTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("A", 1),
                Arguments.of("AB", 28),
                Arguments.of("ZY", 701),
                Arguments.of("FXSHRXW", 2147483647)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testsTitleToNumber(String columnTitle, int expected) {
        // given
        SheetColumnNumber solution = new SheetColumnNumber();

        // when
        int result = solution.titleToNumber(columnTitle);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}