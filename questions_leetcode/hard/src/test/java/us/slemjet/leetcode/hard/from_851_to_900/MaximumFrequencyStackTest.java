package us.slemjet.leetcode.hard.from_851_to_900;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumFrequencyStackTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"},
                        new Integer[]{null, 5, 7, 5, 7, 4, 5, null, null, null, null},
                        new Integer[]{null, null, null, null, null, null, null, 5, 7, 5, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFreqStackBucket(String[] commands, Integer[] params, Integer[] expected) {
        MaximumFrequencyStack.FreqStackBucket freqStack = null;

        for (int i = 0; i < commands.length; i++) {
            if ("FreqStack".equals(commands[i]))
                freqStack = new MaximumFrequencyStack.FreqStackBucket();
            else if ("push".equals(commands[i]))
                freqStack.push(params[i]);
            else if ("pop".equals(commands[i]))
                Assertions.assertThat(freqStack.pop()).isEqualTo(expected[i]);
        }
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFreqStackTreeMap(String[] commands, Integer[] params, Integer[] expected) {
        MaximumFrequencyStack.FreqStackTreeMap freqStack = null;

        for (int i = 0; i < commands.length; i++) {
            if ("FreqStack".equals(commands[i]))
                freqStack = new MaximumFrequencyStack.FreqStackTreeMap();
            else if ("push".equals(commands[i]))
                freqStack.push(params[i]);
            else if ("pop".equals(commands[i]))
                Assertions.assertThat(freqStack.pop()).isEqualTo(expected[i]);
        }
    }
}