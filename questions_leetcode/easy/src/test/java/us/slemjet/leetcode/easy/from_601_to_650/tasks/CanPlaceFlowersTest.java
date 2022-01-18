package us.slemjet.leetcode.easy.from_601_to_650.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CanPlaceFlowersTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 0, 0, 0, 1}, 1, true),
                Arguments.of(new int[]{1, 0, 0, 0, 1}, 2, false),
                Arguments.of(new int[]{1, 0, 0, 0, 0, 1}, 2, false),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 1, 0, 0}, 0, true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCanPlaceFlowers(int[] flowerbed, int n, boolean expected) {
        // given
        CanPlaceFlowers solution = new CanPlaceFlowers();

        // when
        boolean result = solution.canPlaceFlowers(flowerbed, n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCanPlaceFlowers2(int[] flowerbed, int n, boolean expected) {
        // given
        CanPlaceFlowers solution = new CanPlaceFlowers();

        // when
        boolean result = solution.canPlaceFlowers2(flowerbed, n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}