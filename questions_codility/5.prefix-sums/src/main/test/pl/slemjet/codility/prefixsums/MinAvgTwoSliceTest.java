package pl.slemjet.codility.prefixsums;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MinAvgTwoSliceTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{4, 2, 2, 5, 1, 5, 8}, 1),
                Arguments.of(new int[]{10, 10, -1, 2, 4, -1, 2, -1}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(int[] array, int expected) {
        // when
        int result = MinAvgTwoSlice.solution(array);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void findMinAvgSliceIndex() {
        assertEquals(1, MinAvgTwoSlice.findMinAvgSliceIndex(new int[]{4, 2, 2, 5, 1, 5, 8}));
    }

}
