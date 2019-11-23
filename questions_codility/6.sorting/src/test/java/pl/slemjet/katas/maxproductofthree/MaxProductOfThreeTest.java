package pl.slemjet.katas.maxproductofthree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxProductOfThreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[] {-3, 1, 2, -2, 5, 6}, 60)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(int[] array, int expected) {
        // when
        int result = MaxProductOfThree.solution(array);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void getMaxProductOfThree() {
        assertEquals(60, MaxProductOfThree.getMaxProductOfThreeNoSort(new int[] {-3, 1, 2, -2, 5, 6}));
    }
}
