package us.slemjet.leetcode.medium.tasks_2351_2400;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 2353. Design a Food Rating System
 */
public class DesignAFoodRatingSystem {

    /**
     * Time: -> 95.40%
     * Space: -> 95.40%
     */
    static class FoodRatings {

        Map<String, PriorityQueue<Food>> foodRatings;
        Map<String, String> cuisineByFood = new HashMap<>();
        Map<String, Food> foodByName = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

            foodRatings = new HashMap<>();
            for (int i = 0; i < foods.length; i++) {
                String food = foods[i];
                String cuisine = cuisines[i];
                int rating = ratings[i];

                Food newFood = new Food(food, rating);
                foodRatings.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>()).add(newFood);
                cuisineByFood.put(food, cuisine);
                foodByName.put(food, newFood);
            }
        }

        public void changeRating(String food, int newRating) {
            // Update food rating in storage
            Food foodWithNewRating = new Food(food, newRating);
            foodByName.put(food, foodWithNewRating);

            // Add food with new rating to queue
            String cuisine = cuisineByFood.get(food);
            PriorityQueue<Food> priorityQueue = foodRatings.get(cuisine);
            priorityQueue.offer(foodWithNewRating);
        }

        public String highestRated(String cuisine) {
            PriorityQueue<Food> ratingsQueue = foodRatings.get(cuisine);
            Food candidate = ratingsQueue.peek();
            Food actualFood = foodByName.get(candidate.food);

            while (!candidate.ranking.equals(actualFood.ranking)) {
                // Ratings mismatch - rating was updated. discard candidate
                ratingsQueue.poll();
                candidate = ratingsQueue.peek();
                actualFood = foodByName.get(candidate.food);
            }

            return candidate.food;
        }

        static class Food implements Comparable<Food> {
            String food;
            Integer ranking;

            public Food(String food, Integer ranking) {
                this.food = food;
                this.ranking = ranking;
            }

            @Override
            public int compareTo(Food o) {
                // If food ratings are the same, sort based on their names (lexicographically smaller name food will be on top)
                if (Objects.equals(ranking, o.ranking)) {
                    return food.compareTo(o.food);
                }
                // Sort based on food rating (bigger rating food will be on top)
                return -1 * Integer.compare(ranking, o.ranking);
            }
        }
    }
}