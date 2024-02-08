package us.slemjet.leetcode.easy.tasks_1201_1250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UniqueNumberOfOccurrencesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 1, 1, 3}, true),
                Arguments.of(new int[]{1, 2}, false),
                Arguments.of(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testUniqueOccurrences(int[] arr, boolean expected) {
        // given
        UniqueNumberOfOccurrences solution = new UniqueNumberOfOccurrences();

        // when
        boolean result = solution.uniqueOccurrences(arr);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}