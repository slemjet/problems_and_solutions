package us.slemjet.leetcode.medium.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UniqueBinarySearchTreesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(3, 5),
                Arguments.of(4, 14),
                Arguments.of(5, 42),
                Arguments.of(1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testNumTrees(int n, int expected) {
        // given
        UniqueBinarySearchTrees solution = new UniqueBinarySearchTrees();

        // when
        int result = solution.numTrees(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}