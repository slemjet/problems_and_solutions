package us.slemjet.leetcode.easy.from_151_to_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MajorityElementTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 3}, 3),
                Arguments.of(new int[]{2, 2, 1, 1, 1, 2, 2}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] input, int expected) {
        // given
        MajorityElement solution = new MajorityElement();

        // when
        int value = solution.majorityElement(input);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution2(int[] input, int expected) {
        // given
        MajorityElement solution = new MajorityElement();

        // when
        int value = solution.majorityElementHashTable(input);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBit(int[] input, int expected) {
        // given
        MajorityElement solution = new MajorityElement();

        // when
        int value = solution.majorityElementBit(input);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }
}
