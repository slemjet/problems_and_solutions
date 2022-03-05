package us.slemjet.leetcode.medium.tasks_751_800;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ChampagneTowerTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, 1, 1, .0),
                Arguments.of(2, 1, 1, .5),
                Arguments.of(8, 3, 2, 0.875),
                Arguments.of(25, 6, 1, 0.18750),
                Arguments.of(100000009, 33, 17, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testChampagneTower(int poured, int query_row, int query_glass, double expected) {
        // given
        ChampagneTower solution = new ChampagneTower();

        // when
        double value = solution.champagneTower(poured, query_row, query_glass);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testChampagneTowerSingleArray(int poured, int query_row, int query_glass, double expected) {
        // given
        ChampagneTower solution = new ChampagneTower();

        // when
        double value = solution.champagneTowerSingleArray(poured, query_row, query_glass);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }
}