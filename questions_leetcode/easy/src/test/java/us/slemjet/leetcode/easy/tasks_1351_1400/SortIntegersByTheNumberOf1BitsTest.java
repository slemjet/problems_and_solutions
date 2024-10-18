package us.slemjet.leetcode.easy.tasks_1351_1400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SortIntegersByTheNumberOf1BitsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8},
                        new int[]{0, 1, 2, 4, 8, 3, 5, 6, 7}),
                Arguments.of(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1},
                        new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] arr, int[] expected) {
        // given
        SortIntegersByTheNumberOf1Bits solution = new SortIntegersByTheNumberOf1Bits();

        // when
        int[] result = solution.sortByBits(arr);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}