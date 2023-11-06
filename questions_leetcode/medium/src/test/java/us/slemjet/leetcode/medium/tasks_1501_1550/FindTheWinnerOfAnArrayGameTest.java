package us.slemjet.leetcode.medium.tasks_1501_1550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FindTheWinnerOfAnArrayGameTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 3, 5, 4, 6, 7}, 2, 5),
                Arguments.of(new int[]{3, 2, 1}, 10, 3),
                Arguments.of(new int[]{1, 25, 35, 42, 68, 70}, 2, 70)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testGetWinner(int[] arr, int k, int expected) {
        // given
        FindTheWinnerOfAnArrayGame solution = new FindTheWinnerOfAnArrayGame();

        // when
        int result = solution.getWinner(arr, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}