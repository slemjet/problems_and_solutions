package us.slemjet.leetcode.easy.tasks_1401_1450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class DestinationCityTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(
                        List.of("London", "New York"),
                        List.of("New York", "Lima"),
                        List.of("Lima", "Sao Paulo")
                ), "Sao Paulo"),
                Arguments.of(List.of(
                        List.of("B", "C"),
                        List.of("D", "B"),
                        List.of("C", "A")
                ), "A"),
                Arguments.of(List.of(
                        List.of("A", "Z")
                ), "Z")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(List<List<String>> paths, String expected) {
        // given
        DestinationCity solution = new DestinationCity();


        // when
        String result = solution.destCity(paths);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}