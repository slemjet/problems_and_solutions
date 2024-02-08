package pl.slemjet.katas.maxproductofthree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DistinctTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 1, 2, 3, 1}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(int[] array, int expected) {
        // when
        int result = Distinct.solution(array);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void numDistinctValues() {
        assertEquals(3, Distinct.numDistinctValues(new int[]{2, 1, 1, 2, 3, 1}));
    }

    @Test
    void numDistinctValuesNeg() {
        assertEquals(6, Distinct.numDistinctValues(new int[]{-10000, -1, 1, 0, 2, 0, 10000}));
    }

    @Test
    void numDistinctValuesSort() {
        assertEquals(3, Distinct.numDistinctValuesSort(new int[]{2, 1, 1, 2, 3, 1}));
    }

    @Test
    void numDistinctValuesSortNeg() {
        assertEquals(6, Distinct.numDistinctValuesSort(new int[]{-10000, -1, 1, 0, 2, 0, 10000}));
    }

}
