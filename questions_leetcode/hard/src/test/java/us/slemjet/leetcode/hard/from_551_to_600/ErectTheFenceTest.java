package us.slemjet.leetcode.hard.from_551_to_600;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class ErectTheFenceTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new int[][]{new int[]{1, 1}, new int[]{2, 2}, new int[]{2, 0}, new int[]{2, 4}, new int[]{3, 3}, new int[]{4, 2}},
                        new int[][]{new int[]{1, 1}, new int[]{2, 0}, new int[]{2, 4}, new int[]{3, 3}, new int[]{4, 2}}),
                Arguments.of(
                        new int[][]{new int[]{1, 2}, new int[]{2, 2}, new int[]{4, 2}},
                        new int[][]{new int[]{1, 2}, new int[]{2, 2}, new int[]{4, 2}})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testOuterTreesMonotonousChain(int[][] trees, int[][] expected) {
        // given
        ErectTheFence solution = new ErectTheFence();

        // when
        int[][] result = solution.outerTreesMonotonousChain(trees);

        // then
        Assertions.assertThat(Arrays.asList(result)).containsExactlyInAnyOrder(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testOuterTreesGraham(int[][] trees, int[][] expected) {
        // given
        ErectTheFence solution = new ErectTheFence();

        // when
        int[][] result = solution.outerTreesGraham(trees);

        // then
        Assertions.assertThat(Arrays.asList(result)).containsExactlyInAnyOrder(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testOuterTreesJarvis(int[][] trees, int[][] expected) {
        // given
        ErectTheFence solution = new ErectTheFence();

        // when
        int[][] result = solution.outerTreesJarvis(trees);

        // then
        Assertions.assertThat(Arrays.asList(result)).containsExactlyInAnyOrder(expected);
    }

}