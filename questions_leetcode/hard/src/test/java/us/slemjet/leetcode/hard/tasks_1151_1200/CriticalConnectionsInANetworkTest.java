package us.slemjet.leetcode.hard.tasks_1151_1200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class CriticalConnectionsInANetworkTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(4, List.of(List.of(0, 1), List.of(1, 2), List.of(2, 0), List.of(1, 3)),
                        List.of(List.of(3, 1), List.of(1, 3))),
                Arguments.of(6, List.of(List.of(0, 1), List.of(1, 2), List.of(2, 0), List.of(1, 3), List.of(3, 4), List.of(4, 5), List.of(5, 3)),
                        List.of(List.of(3, 1), List.of(1, 3))),
                Arguments.of(2, List.of(List.of(0, 1)), List.of(List.of(1, 0), List.of(0, 1)))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCriticalConnections(int n, List<List<Integer>> connections, List<List<Integer>> expected) {
        // given
        CriticalConnectionsInANetwork solution = new CriticalConnectionsInANetwork();

        // when
        List<List<Integer>> result = solution.criticalConnections(n, connections);

        // then
        Assertions.assertThat(expected).containsAll(result);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCriticalConnections2(int n, List<List<Integer>> connections, List<List<Integer>> expected) {
        // given
        CriticalConnectionsInANetwork solution = new CriticalConnectionsInANetwork();

        // when
        List<List<Integer>> result = solution.criticalConnections2(n, connections);

        // then
        Assertions.assertThat(expected).containsAll(result);
    }
}