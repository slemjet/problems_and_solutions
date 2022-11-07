package us.slemjet.leetcode.easy.from_1351_to_1400.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Maximum69NumberTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(9669, 9969),
                Arguments.of(9996, 9999),
                Arguments.of(9999, 9999),
                Arguments.of(669, 969)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaximum69Number(int num, int expected) {
        // given
        Maximum69Number solution = new Maximum69Number();

        // when
        int result = solution.maximum69Number(num);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}