package us.slemjet.leetcode.easy.from_201_to_250.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class SummaryRangesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{}, new ArrayList<>()),
                Arguments.of(new int[]{0, 1, 2, 4, 5, 7}, List.of("0->2", "4->5", "7")),
                Arguments.of(new int[]{0, 2, 3, 4, 6, 8, 9}, List.of("0", "2->4", "6", "8->9"))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSummaryRanges(int[] nums, List<String> expected) {
        // given
        SummaryRanges solution = new SummaryRanges();

        // when
        List<String> value = solution.summaryRanges(nums);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSummaryRangesShort(int[] nums, List<String> expected) {
        // given
        SummaryRanges solution = new SummaryRanges();

        // when
        List<String> value = solution.summaryRangesShort(nums);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }
}