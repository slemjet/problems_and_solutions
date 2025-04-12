package us.slemjet.leetcode.easy.tasks_2801_2850;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CountSymmetricIntegersTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, 100, 9),
                Arguments.of(1200, 1230, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int low, int high, int expected) {
        // given
        CountSymmetricIntegers solution = new CountSymmetricIntegers();

        // when
        int result = solution.countSymmetricIntegers(low, high);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}