package us.slemjet.leetcode.medium.tasks_751_800;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class OpenTheLockTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202", 6),
                Arguments.of(new String[]{"8888"}, "0009", 1),
                Arguments.of(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888", -1),
                Arguments.of(new String[]{"0000"}, "8888", -1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String[] deadends, String target, int expected) {
        // given
        OpenTheLock solution = new OpenTheLock();

        // when
        int result = solution.openLock(deadends, target);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}