package us.slemjet.leetcode.easy.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AddBinaryTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("111", "1", "1000"),
                Arguments.of("11", "1", "100"),
                Arguments.of("1010", "1011", "10101"),
                Arguments.of("1111", "1111", "11110"),
                Arguments.of("100", "110010", "110110")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void addBinary(String a, String b, String expected) {
        // given
        AddBinary solution = new AddBinary();

        // when
        String result = solution.addBinary(a, b);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
