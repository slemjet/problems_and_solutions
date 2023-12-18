package us.slemjet.leetcode.medium.tasks_2351_2400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DesignAFoodRatingSystemTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"},
                        new Object[][]{
                                null,
                                new String[]{"korean"},
                                new String[]{"japanese"},
                                new Object[]{"sushi", 16},
                                new String[]{"japanese"},
                                new Object[]{"ramen", 16},
                                new String[]{"japanese"},
                        },
                        new Object[]{null, "kimchi", "ramen", null, "sushi", null, "ramen"})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String[] commands, Object[][] params, Object[] expected) {
        DesignAFoodRatingSystem.FoodRatings foodRatings = null;

        for (int i = 0; i < commands.length; i++) {
            if ("FoodRatings".equals(commands[i]))
                foodRatings = new DesignAFoodRatingSystem.FoodRatings(
                        new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                        new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                        new int[]{9, 12, 8, 15, 14, 7}
                );
            else if ("highestRated".equals(commands[i]))
                Assertions.assertThat(foodRatings.highestRated((String) params[i][0])).isEqualTo(expected[i]);
            else if ("changeRating".equals(commands[i]))
                foodRatings.changeRating((String) params[i][0], (Integer) params[i][1]);
        }
    }

}