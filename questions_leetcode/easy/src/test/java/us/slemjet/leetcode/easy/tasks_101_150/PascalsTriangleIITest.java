package us.slemjet.leetcode.easy.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class PascalsTriangleIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(3, Arrays.asList(1, 3, 3, 1)),
                Arguments.of(0, Arrays.asList(1)),
                Arguments.of(1, Arrays.asList(1, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testGetRow(int rowIndex, List<Integer> expected) {
        // given
        PascalsTriangleII solution = new PascalsTriangleII();

        // when
        List<Integer> result = solution.getRow(rowIndex);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
