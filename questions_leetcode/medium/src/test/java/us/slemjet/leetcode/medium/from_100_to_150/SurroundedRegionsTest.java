package us.slemjet.leetcode.medium.from_100_to_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SurroundedRegionsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        // ['X','O','X','O','X','O']        ['X','O','X','O','X','O']
                        // ['O','X','O','X','O','X']        ['O','X','X','X','X','X']
                        // ['X','O','X','O','X','O']    ==> ['X','X','X','X','X','O']
                        // ['O','X','O','X','O','X']        ['O','X','O','X','O','X']
                        new char[][]{
                                new char[]{'X','O','X','O','X','O'},
                                new char[]{'O','X','O','X','O','X'},
                                new char[]{'X','O','X','O','X','O'},
                                new char[]{'O','X','O','X','O','X'}},
                        new char[][]{
                                new char[]{'X','O','X','O','X','O'},
                                new char[]{'O','X','X','X','X','X'},
                                new char[]{'X','X','X','X','X','O'},
                                new char[]{'O','X','O','X','O','X'}})
                ,Arguments.of(
                        // ['X','X','X','X']        ['X','X','X','X']
                        // ['X','O','O','X']        ['X','X','X','X']
                        // ['X','X','O','X']  ==>   ['X','X','X','X']
                        // ['X','O','X','X']        ['X','O','X','X']
                        new char[][]{
                                new char[]{'X', 'X', 'X', 'X'},
                                new char[]{'X', 'O', 'O', 'X'},
                                new char[]{'X', 'X', 'O', 'X'},
                                new char[]{'X', 'O', 'X', 'X'}},
                        new char[][]{
                                new char[]{'X', 'X', 'X', 'X'},
                                new char[]{'X', 'X', 'X', 'X'},
                                new char[]{'X', 'X', 'X', 'X'},
                                new char[]{'X', 'O', 'X', 'X'}})
                , Arguments.of(
                        new char[][]{new char[]{'X'}},
                        new char[][]{new char[]{'X'}})

        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solveTest(char[][] board, char[][] expected) {
        // given
        SurroundedRegions solution = new SurroundedRegions();

        // when
        solution.solve(board);

        // then
        Assertions.assertThat(board).isEqualTo(expected);
    }

}
