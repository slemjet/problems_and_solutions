package pl.slemjet.katas.maxproductofthree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfDiscIntersectionsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 2, 1, 4, 0}, 11),
                Arguments.of(new int[]{2, 2147483647, 0}, 2)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(int[] array, int expected) {
        // when
        int result = NumberOfDiscIntersections.solution(array);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void getNumberOfDiscIntersections() {
        assertEquals(11, NumberOfDiscIntersections.getNumberOfDiscIntersections(new int[]{1, 5, 2, 1, 4, 0}));
    }

    @Test
    void getNumberOfDiscIntersectionsBig() {
        assertEquals(2, NumberOfDiscIntersections.getNumberOfDiscIntersections(new int[]{1, 2147483647, 0}));
    }
}
