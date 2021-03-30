package us.slemjet.leetcode.medium.from_1_to_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.params.provider.Arguments.of;

class PermutationsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{1, 2, 3},
                        asList(
                                asList(1, 2, 3),
                                asList(1, 3, 2),
                                asList(2, 1, 3),
                                asList(2, 3, 1),
                                asList(3, 1, 2),
                                asList(3, 2, 1)
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void permuteTest(int[] nums, List<List<Integer>> expected) {
        // given
        Permutations solution = new Permutations();

        // when
        List<List<Integer>> result = solution.permute(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void permuteNewListsTest(int[] nums, List<List<Integer>> expected) {
        // given
        Permutations solution = new Permutations();

        // when
        List<List<Integer>> result = solution.permuteNewLists(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
