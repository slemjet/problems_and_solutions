package us.slemjet.leetcode.medium.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class PalindromePartitioningTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("efe", Arrays.asList(Arrays.asList("e", "f", "e"), Arrays.asList("efe"))),
                Arguments.of("aab", Arrays.asList(Arrays.asList("a", "a", "b"), Arrays.asList("aa", "b"))),
                Arguments.of("a", Arrays.asList(Arrays.asList("a")))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testPartitionBfs(String s, List<List<String>> expected) {
        // given
        PalindromePartitioning solution = new PalindromePartitioning();

        // when
        List<List<String>> result = solution.partitionBfs(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testPartitionDp(String s, List<List<String>> expected) {
        // given
        PalindromePartitioning solution = new PalindromePartitioning();

        // when
        List<List<String>> result = solution.partitionDp(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
