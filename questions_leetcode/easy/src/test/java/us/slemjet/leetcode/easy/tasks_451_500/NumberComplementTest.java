package us.slemjet.leetcode.easy.tasks_451_500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class NumberComplementTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(1, 0),
                of(5, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void frequencySort(int num, int expected) {
        // given
        NumberComplement solution = new NumberComplement();

        // when
        int result = solution.findComplement(num);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
