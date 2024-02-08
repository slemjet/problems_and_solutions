package us.slemjet.leetcode.easy.tasks_901_950;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongPressedNameTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("alex", "aaleex", true),
                Arguments.of("saeed", "ssaaedd", false),
                Arguments.of("leelee", "lleeelee", true),
                Arguments.of("laiden", "laiden", true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void isLongPressedName(String name, String typed, boolean expected) {
        // when
        boolean isValid = LongPressedName.isLongPressedName(name, typed);

        // then
        Assertions.assertThat(isValid).isEqualTo(expected);
    }
}
