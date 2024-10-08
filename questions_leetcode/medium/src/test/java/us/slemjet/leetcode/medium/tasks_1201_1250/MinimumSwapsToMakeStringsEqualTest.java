package us.slemjet.leetcode.medium.tasks_1201_1250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumSwapsToMakeStringsEqualTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("xx", "yy", 1),
                Arguments.of("xy", "yx", 2),
                Arguments.of("xx", "xy", -1),
                Arguments.of("xxyyxyxyxx", "xyyxyxxxyx", 4),
                Arguments.of("xyyxxyyyyyyy", "xxxyxyxxxxyx", 5)
        );
    }
    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s1, String s2, int expected) {
        // given
        MinimumSwapsToMakeStringsEqual solution = new MinimumSwapsToMakeStringsEqual();

        // when
        int result = solution.minimumSwap(s1, s2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution2(String s1, String s2, int expected) {
        // given
        MinimumSwapsToMakeStringsEqual solution = new MinimumSwapsToMakeStringsEqual();

        // when
        int result = solution.minimumSwap2(s1, s2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}