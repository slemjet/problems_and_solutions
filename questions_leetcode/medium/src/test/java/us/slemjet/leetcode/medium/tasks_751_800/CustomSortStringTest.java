package us.slemjet.leetcode.medium.tasks_751_800;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CustomSortStringTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("cba", "abcd", "cbad"),
                Arguments.of("bcafg", "abcd", "bcad")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String order, String s, String expected) {
        // given
        CustomSortString solution = new CustomSortString();

        // when
        String result = solution.customSortString(order, s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}