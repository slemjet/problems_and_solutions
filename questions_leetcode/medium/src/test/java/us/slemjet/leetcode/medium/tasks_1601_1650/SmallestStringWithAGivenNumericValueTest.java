package us.slemjet.leetcode.medium.tasks_1601_1650;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SmallestStringWithAGivenNumericValueTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(3, 27, "aay"),
                Arguments.of(5, 73, "aaszz"),
                Arguments.of(5, 55, "aaazz"),
                Arguments.of(5, 31, "aaabz")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testGetSmallestString(int n, int k, String expected) {
        // given
        SmallestStringWithAGivenNumericValue solution = new SmallestStringWithAGivenNumericValue();

        // when
        String result = solution.getSmallestString(n, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testGetSmallestString2(int n, int k, String expected) {
        // given
        SmallestStringWithAGivenNumericValue solution = new SmallestStringWithAGivenNumericValue();

        // when
        String result = solution.getSmallestString2(n, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}