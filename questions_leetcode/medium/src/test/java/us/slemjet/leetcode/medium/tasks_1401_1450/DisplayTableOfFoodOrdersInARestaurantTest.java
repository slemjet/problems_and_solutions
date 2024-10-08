package us.slemjet.leetcode.medium.tasks_1401_1450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class DisplayTableOfFoodOrdersInARestaurantTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                List.of("David", "3", "Ceviche"),
                                List.of("Corina", "10", "Beef Burrito"),
                                List.of("David", "3", "Fried Chicken"),
                                List.of("Carla", "5", "Water"),
                                List.of("Carla", "5", "Ceviche"),
                                List.of("Rous", "3", "Ceviche")),
                        List.of(
                                List.of("Table", "Beef Burrito", "Ceviche", "Fried Chicken", "Water"),
                                List.of("3", "0", "2", "1", "0"),
                                List.of("5", "0", "1", "0", "1"),
                                List.of("10", "1", "0", "0", "0")
                        )),
                Arguments.of(
                        List.of(
                                List.of("James", "12", "Fried Chicken"),
                                List.of("Ratesh", "12", "Fried Chicken"),
                                List.of("Amadeus", "12", "Fried Chicken"),
                                List.of("Adam", "1", "Canadian Waffles"),
                                List.of("Brianna", "1", "Canadian Waffles")),
                        List.of(
                                List.of("Table", "Canadian Waffles", "Fried Chicken"),
                                List.of("1", "2", "0"),
                                List.of("12", "0", "3")
                        )),
                Arguments.of(
                        List.of(
                                List.of("Laura", "2", "Bean Burrito"),
                                List.of("Jhon", "2", "Beef Burrito"),
                                List.of("Melissa", "2", "Soda")
                        ),
                        List.of(
                                List.of("Table", "Bean Burrito", "Beef Burrito", "Soda"),
                                List.of("2", "1", "1", "1")
                        ))
        );
    }


    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(List<List<String>> orders, List<List<String>> expected) {
        // given
        DisplayTableOfFoodOrdersInARestaurant solution = new DisplayTableOfFoodOrdersInARestaurant();

        // when
        List<List<String>> result = solution.displayTable(orders);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution2(List<List<String>> orders, List<List<String>> expected) {
        // given
        DisplayTableOfFoodOrdersInARestaurant solution = new DisplayTableOfFoodOrdersInARestaurant();

        // when
        List<List<String>> result = solution.displayTable2(orders);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}