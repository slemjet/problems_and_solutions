package us.slemjet.hackerrank.questions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class AppleAndOrangeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(7, 11, 5, 15, new ArrayList<>(List.of(-2, 2, 1)), new ArrayList<>(List.of(5, -6)))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {

        // given
        AppleAndOrange solution = new AppleAndOrange();

        // when
        solution.countApplesAndOranges(s, t, a, b, apples, oranges);

        // then
        // Prints to console
    }
}