package us.slemjet.leetcode.medium.tasks_1_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.params.provider.Arguments.of;

class Permutations2Test {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{1, 1, 2},
                        asList(
                                asList(1, 1, 2),
                                asList(1, 2, 1),
                                asList(2, 1, 1)
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void permuteTest(int[] nums, List<List<Integer>> expected) {
        // given
        Permutations2 solution = new Permutations2();

        // when
        List<List<Integer>> result = solution.permuteUnique(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
