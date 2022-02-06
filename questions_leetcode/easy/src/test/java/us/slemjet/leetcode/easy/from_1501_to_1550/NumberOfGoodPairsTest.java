package us.slemjet.leetcode.easy.from_1501_to_1550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumberOfGoodPairsTest {


    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1, 1, 3}, 4),
                Arguments.of(new int[]{1, 1, 1, 1}, 6),
                Arguments.of(new int[]{1, 2, 3}, 0));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testNumIdenticalPairs(int[] nums, int expected) {
        // given
        NumberOfGoodPairs solution = new NumberOfGoodPairs();

        // when
        int result = solution.numIdenticalPairs(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testNumIdenticalPairsMath(int[] nums, int expected) {
        // given
        NumberOfGoodPairs solution = new NumberOfGoodPairs();

        // when
        int result = solution.numIdenticalPairsMath(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}