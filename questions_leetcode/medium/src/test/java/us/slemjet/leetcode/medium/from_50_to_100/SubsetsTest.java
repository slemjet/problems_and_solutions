package us.slemjet.leetcode.medium.from_50_to_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class SubsetsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3},
                        Arrays.asList(
                                Collections.singletonList(3),
                                Collections.singletonList(1),
                                Collections.singletonList(2),
                                Arrays.asList(1, 2, 3),
                                Arrays.asList(1, 3),
                                Arrays.asList(2, 3),
                                Arrays.asList(1, 2),
                                new ArrayList<Integer>()
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void subsets(int[] nums, List<List<Integer>> expected) {
        // given
        Subsets solution = new Subsets();

        // when
        List<List<Integer>> result = solution.subsets(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void subsetsBit(int[] nums, List<List<Integer>> expected) {
        // given
        Subsets solution = new Subsets();

        // when
        List<List<Integer>> result = solution.subsetsBit(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
