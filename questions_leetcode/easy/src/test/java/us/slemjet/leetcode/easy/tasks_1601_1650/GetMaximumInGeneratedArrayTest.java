package us.slemjet.leetcode.easy.tasks_1601_1650;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class GetMaximumInGeneratedArrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(7, 3),
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(0, 0),
                Arguments.of(1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testGetMaximumGenerated(int n, int expected) {
        // given
        GetMaximumInGeneratedArray solution = new GetMaximumInGeneratedArray();

        // when
        int result = solution.getMaximumGenerated(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}