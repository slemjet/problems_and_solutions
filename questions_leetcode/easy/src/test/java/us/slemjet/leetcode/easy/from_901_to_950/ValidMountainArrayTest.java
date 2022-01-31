package us.slemjet.leetcode.easy.from_901_to_950;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_901_to_950.ValidMountainArray;

import java.util.stream.Stream;

class ValidMountainArrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 1}, false),
                Arguments.of(new int[]{3, 5, 5}, false),
                Arguments.of(new int[]{0, 3, 2, 1}, true),
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, false),
                Arguments.of(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testValidMountainArray(int[] arr, boolean expected) {
        // given
        ValidMountainArray solution = new ValidMountainArray();

        // when
        boolean result = solution.validMountainArray(arr);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testValidMountainArray2(int[] arr, boolean expected) {
        // given
        ValidMountainArray solution = new ValidMountainArray();

        // when
        boolean result = solution.validMountainArray2(arr);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}