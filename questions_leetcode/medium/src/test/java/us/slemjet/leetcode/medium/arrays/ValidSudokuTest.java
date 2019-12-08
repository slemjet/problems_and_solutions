package us.slemjet.leetcode.medium.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ValidSudokuTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new char[][]{
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }, true),
                Arguments.of(new char[][]{
                        {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }, false),
                Arguments.of(new char[][]{
                        {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                        {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                        {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                        {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                        {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                        {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                        {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
                }, false),
                Arguments.of(new char[][]{
                        {'.', '.', '.', '9', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '3', '.', '.', '.', '.', '.', '1'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'1', '.', '.', '.', '.', '.', '3', '.', '.'},
                        {'.', '.', '.', '.', '2', '.', '6', '.', '.'},
                        {'.', '9', '.', '.', '.', '.', '.', '7', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'8', '.', '.', '8', '.', '.', '.', '.', '.'}
                }, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void isValidSudoku(char[][] board, boolean expected) {
        // given
        ValidSudoku solution = new ValidSudoku();

        // when
        boolean number = solution.isValidSudoku(board);

        // then
        Assertions.assertThat(number).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void isValidSudoku2(char[][] board, boolean expected) {
        // given
        ValidSudoku solution = new ValidSudoku();

        // when
        boolean number = solution.isValidSudoku2(board);

        // then
        Assertions.assertThat(number).isEqualTo(expected);
    }
}
