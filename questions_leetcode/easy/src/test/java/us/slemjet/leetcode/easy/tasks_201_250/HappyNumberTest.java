package us.slemjet.leetcode.easy.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class HappyNumberTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(19, true),
                Arguments.of(2, false),
                Arguments.of(4, false),
                Arguments.of(30, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testsIsHappy(int n, boolean expected) {
        // given
        HappyNumber solution = new HappyNumber();

        // when
        boolean result = solution.isHappy(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testsIsHappyAlt(int n, boolean expected) {
        // given
        HappyNumber solution = new HappyNumber();

        // when
        boolean result = solution.isHappyAlt(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}