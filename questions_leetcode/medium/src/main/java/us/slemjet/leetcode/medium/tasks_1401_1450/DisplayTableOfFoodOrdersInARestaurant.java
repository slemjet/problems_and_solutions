package us.slemjet.leetcode.medium.tasks_1401_1450;

import java.util.*;

/**
 * 1418. Display Table of Food Orders in a Restaurant
 */
public class DisplayTableOfFoodOrdersInARestaurant {

    /**
     * Time:    O(nlogn)    ->  93.49%
     * Space:   O(n)        ->  82.74%
     */
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> result = new ArrayList<>();

        Set<String> uniqueDishes = new TreeSet<>();
        TreeMap<Integer, TreeMap<String, Integer>> tableOrders = new TreeMap<>();

        processOrders(orders, uniqueDishes, tableOrders);

        List<String> orderedDishes = new ArrayList<>(uniqueDishes);
        Collections.sort(orderedDishes);

        List<String> header = createHeader(orderedDishes);
        result.add(header);

        createRows(tableOrders, orderedDishes, header.size(), result);

        return result;
    }

    private void processOrders(List<List<String>> orders, Set<String> uniqueDishes, TreeMap<Integer, TreeMap<String, Integer>> tableOrders) {
        for (List<String> order : orders) {
            Integer table = Integer.valueOf(order.get(1));
            String dish = order.get(2);
            uniqueDishes.add(dish);
            tableOrders.putIfAbsent(table, new TreeMap<>());
            tableOrders.get(table).put(dish, tableOrders.get(table).getOrDefault(dish, 0) + 1);
        }
    }

    private List<String> createHeader(List<String> orderedDishes) {
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(orderedDishes);
        return header;
    }

    private void createRows(TreeMap<Integer, TreeMap<String, Integer>> tableOrders, List<String> orderedDishes, int headerSize, List<List<String>> result) {
        Map<String, Integer> dishIndexMap = new HashMap<>();
        for (int i = 0; i < orderedDishes.size(); i++) {
            dishIndexMap.put(orderedDishes.get(i), i);
        }

        tableOrders.forEach((table, dishes) -> {
            List<String> row = new ArrayList<>(Collections.nCopies(headerSize, "0"));
            row.set(0, String.valueOf(table));
            dishes.forEach((dish, count) -> {
                int index = dishIndexMap.get(dish) + 1;
                row.set(index, String.valueOf(count));
            });
            result.add(row);
        });
    }

    /**
     * Time:    O(nlogn)    ->  7.40%
     * Space:   O(n)        ->  36.98%
     */
    public List<List<String>> displayTable2(List<List<String>> orders) {

        List<List<String>> result = new ArrayList<>();

        TreeMap<Integer, TreeMap<String, Integer>> tableOrders = new TreeMap<>();
        Set<String> dishes = new TreeSet<>();

        for (List<String> order : orders) {
            Integer table = Integer.valueOf(order.get(1));
            String food = order.get(2);
            dishes.add(food);

            tableOrders.putIfAbsent(table, new TreeMap<>());
            tableOrders.get(table).put(food, tableOrders.get(table).getOrDefault(food, 0) + 1);
        }

        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(dishes);

        result.add(header);

        for (Integer table : tableOrders.keySet()) {
            List<String> row = new ArrayList<>(header.size());
            row.add(String.valueOf(table));

            for (String dish : dishes) {
                row.add(String.valueOf(tableOrders.get(table).getOrDefault(dish, 0)));
            }
            result.add(row);
        }

        return result;
    }
}
