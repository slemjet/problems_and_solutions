package us.slemjet.leetcode.easy.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class PascalsTriangleTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(5, Arrays.asList(
                        Arrays.asList(1),
                        Arrays.asList(1, 1),
                        Arrays.asList(1, 2, 1),
                        Arrays.asList(1, 3, 3, 1),
                        Arrays.asList(1, 4, 6, 4, 1))),
                Arguments.of(1, Arrays.asList(
                        Arrays.asList(1)))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void removeGenerate(int input, List<List<Integer>> expected) {
        // given
        PascalsTriangle solution = new PascalsTriangle();

        // when
        List<List<Integer>> result = solution.generate(input);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void removeGenerate2(int input, List<List<Integer>> expected) {
        // given
        PascalsTriangle solution = new PascalsTriangle();

        // when
        List<List<Integer>> result = solution.generate2(input);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
