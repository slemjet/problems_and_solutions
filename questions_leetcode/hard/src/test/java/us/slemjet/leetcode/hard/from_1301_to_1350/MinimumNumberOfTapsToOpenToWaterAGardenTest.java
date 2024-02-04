package us.slemjet.leetcode.hard.from_1301_to_1350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumNumberOfTapsToOpenToWaterAGardenTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(5, new int[]{3, 4, 1, 1, 0, 0}, 1),
                Arguments.of(3, new int[]{0, 0, 0, 0}, -1),
                Arguments.of(97, new int[]{1, 5, 3, 1, 4, 5, 5, 1, 2, 0, 2, 2, 4, 3, 0, 0, 1, 4, 5, 5, 0, 3, 5, 1, 1, 0, 0, 0, 4, 1, 1, 1, 0, 4, 4, 1, 0, 0, 2, 5, 5, 4, 4, 4, 2, 4, 3, 4, 4, 2, 3, 4, 0, 2, 0, 1, 0, 4, 2, 3, 0, 0, 0, 1, 5, 2, 0, 2, 4, 4, 3, 3, 0, 0, 3, 1, 1, 1, 4, 2, 5, 2, 3, 1, 0, 1, 0, 2, 4, 3, 4, 0, 2, 4, 1, 1, 2, 5}, 15)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionDP(int n, int[] ranges, int expected) {
        // given
        MinimumNumberOfTapsToOpenToWaterAGarden solution = new MinimumNumberOfTapsToOpenToWaterAGarden();

        // when
        int result = solution.minTapsDP(n, ranges);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionGreedy(int n, int[] ranges, int expected) {
        // given
        MinimumNumberOfTapsToOpenToWaterAGarden solution = new MinimumNumberOfTapsToOpenToWaterAGarden();

        // when
        int result = solution.minTapsGreedy(n, ranges);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}