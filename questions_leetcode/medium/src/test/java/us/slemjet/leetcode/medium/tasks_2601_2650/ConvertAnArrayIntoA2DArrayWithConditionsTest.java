package us.slemjet.leetcode.medium.tasks_2601_2650;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class ConvertAnArrayIntoA2DArrayWithConditionsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 4, 1, 2, 3, 1},
                        List.of(List.of(1, 3, 4, 2),
                                List.of(1, 3),
                                List.of(1))),
                Arguments.of(new int[]{1, 2, 3, 4},
                        List.of(List.of(4, 3, 2, 1)))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBottomUpDP(int[] nums, List<List<Integer>> expected) {
        // given
        ConvertAnArrayIntoA2DArrayWithConditions solution = new ConvertAnArrayIntoA2DArrayWithConditions();

        // when
        List<List<Integer>> result = solution.findMatrix(nums);

        // then
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertThat(expected.get(i)).containsExactlyInAnyOrderElementsOf(result.get(i));
        }
    }
}