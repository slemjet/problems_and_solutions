package us.slemjet.leetcode.medium.tasks_751_800;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class PartitionLabelsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("ababcbacadefegdehijhklij", List.of(9, 7, 8)),
                Arguments.of("eccbbbbdec", List.of(10))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testPartitionLabels(String s, List<Integer> expected) {
        // given
        PartitionLabels solution = new PartitionLabels();

        // when
        List<Integer> result = solution.partitionLabels(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}