package pl.slemjet.kata.tapeequilibrium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TapeEquilibriumTest {


    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{3, 1, 2, 4, 3}, 1),
                Arguments.of(new int[]{1, 1, 3}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void reverseTest(int[] array, int expected) {
        // when
        int result = TapeEquilibrium.solution(array);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void testSolution() {
        int[] array = new int[]{3, 1, 2, 4, 3};
        assertEquals(1, TapeEquilibrium.solution(array));

        int[] array2 = new int[]{1, 1, 3};
        assertEquals(1, TapeEquilibrium.solution(array2));
    }

    @Test
    void minSplitDifferenceTest() {
        int[] array = new int[]{3, 1, 2, 4, 3};
        assertEquals(1, TapeEquilibrium.minSplitDifference(array));
    }


    @Test
    void minSplitDifferenceTestWithNegs() {
        int[] array = new int[]{3, -1, 2, 4, 3, 5, -7, 3, 6};
        assertEquals(0, TapeEquilibrium.minSplitDifference(array));
    }
}
