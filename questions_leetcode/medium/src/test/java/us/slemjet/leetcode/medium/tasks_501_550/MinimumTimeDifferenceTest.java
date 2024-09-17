package us.slemjet.leetcode.medium.tasks_501_550;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumTimeDifferenceTest {

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(Arrays.asList("23:59", "00:00"), 1),
                Arguments.of(Arrays.asList("00:00", "23:59", "00:00"), 0),
                Arguments.of(Arrays.asList("01:01", "02:01"), 60),
                Arguments.of(Arrays.asList("05:31", "22:08", "00:35"), 147)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testFindMinDifference(List<String> timePoints, int expected) {
        // Given
        MinimumTimeDifference solution = new MinimumTimeDifference();
        // When
        int result = solution.findMinDifference(timePoints);
        // Then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testFindMinDifferenceBucket(List<String> timePoints, int expected) {
        // Given
        MinimumTimeDifference solution = new MinimumTimeDifference();
        // When
        int result = solution.findMinDifferenceBucket(timePoints);
        // Then
        assertThat(result).isEqualTo(expected);
    }
}