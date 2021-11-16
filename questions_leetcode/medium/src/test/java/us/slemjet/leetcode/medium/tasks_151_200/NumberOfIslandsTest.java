package us.slemjet.leetcode.medium.tasks_151_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumberOfIslandsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(

                Arguments.of(new char[][]{
                        new char[]{'1', '1', '1', '1', '0'},
                        new char[]{'1', '1', '0', '1', '0'},
                        new char[]{'1', '1', '0', '0', '0'},
                        new char[]{'0', '0', '0', '0', '0'}
                }, 1),
                Arguments.of(new char[][]{
                        new char[]{'1', '1', '0', '0', '0'},
                        new char[]{'1', '1', '0', '0', '0'},
                        new char[]{'0', '0', '1', '0', '0'},
                        new char[]{'0', '0', '0', '1', '1'}
                }, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testsNumIslands(char[][] grid, int expected) {
        // given
        NumberOfIslands solution = new NumberOfIslands();

        // when
        int result = solution.numIslands(grid);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}