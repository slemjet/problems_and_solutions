package us.slemjet.leetcode.medium.tasks_151_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CompareVersionNumbersTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1.01", "1.001", 0),
                Arguments.of("1.0", "1.0.0", 0),
                Arguments.of("0.1", "1.1", -1),
                Arguments.of("1.0.1", "1", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCompareVersion(String version1, String version2, int expected) {
        // given
        CompareVersionNumbers solution = new CompareVersionNumbers();

        // when
        int value = solution.compareVersion(version1, version2);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }
}