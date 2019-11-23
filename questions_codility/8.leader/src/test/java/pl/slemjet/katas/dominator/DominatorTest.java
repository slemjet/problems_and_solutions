package pl.slemjet.katas.dominator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DominatorTest {

    @Test
    void getDominator() {
        assertThat(Dominator.solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3})).isIn(0, 2, 4, 6, 7);
    }
}
