package us.slemjet.leetcode.hard.from_1401_to_1450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisonsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(2, 3, 1, 6),
                Arguments.of(5, 2, 3, 0),
                Arguments.of(9, 1, 1, 1),
                Arguments.of(4, 4, 4, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionTopToBottom(int n, int m, int k, int expected) {
        // given
        BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons solution = new BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons();

        // when
        int result = solution.numOfArraysTopToBottom(n, m, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }


    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBottomUp(int n, int m, int k, int expected) {
        // given
        BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons solution = new BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons();

        // when
        int result = solution.numOfArraysBottomUp(n, m, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}