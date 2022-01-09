package us.slemjet.leetcode.medium.tasks_1001_1050.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RobotBoundedInCircleTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("GGLLGG", true),
                Arguments.of("GG", false),
                Arguments.of("GL", true),
                Arguments.of("LGR", false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testIsRobotBounded(String instructions, boolean expected) {
        // given
        RobotBoundedInCircle solution = new RobotBoundedInCircle();

        // when
        boolean result = solution.isRobotBounded(instructions);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}