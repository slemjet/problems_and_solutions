package us.slemjet.leetcode.medium.strings;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortCharactersByFrequency {

    /**
     * Runtime: 61 ms, faster than 12.90%
     * Memory Usage: 49.6 MB, less than 5.17%
     */
    public String frequencySort(String s) {

        return Stream.of(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .flatMap(entry -> Stream.generate(entry::getKey).limit(entry.getValue()))
                .collect(Collectors.joining());
    }

    /**
     Runtime: 60 ms, faster than 13.00%
     Memory Usage: 49.1 MB, less than 5.17%
     */
    public String frequencySortMap(String s) {

        Map<String, Long> occurrenceMap = Stream.of(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Long, List<String>> weightedValues = new TreeMap<>(Collections.reverseOrder());

        occurrenceMap.entrySet().forEach(entry -> {
            String valueStr = Stream.generate(entry::getKey).limit(entry.getValue()).collect(Collectors.joining());
            List<String> value = weightedValues.getOrDefault(entry.getValue(), new ArrayList<>());
            value.add(valueStr);
            weightedValues.put(entry.getValue(), value);
        });

        return weightedValues.values().stream().flatMap(Collection::stream).collect(Collectors.joining());
    }

    /**
     * Runtime: 14 ms, faster than 65.88%
     * Memory Usage: 40.5 MB, less than 45.22%
     */
    public String frequencySortArr(String s) {

        if (s.length() < 2) return s;

        char[] chars = s.toCharArray();

        int[] occurrences = new int[256];

        int max = Integer.MIN_VALUE;

        // Populate array containing occurrences of char
        for (char sChar : chars) {
            int occurrence = occurrences[sChar];
            occurrence++;
            max = Math.max(occurrence, max);
            occurrences[sChar] = occurrence;
        }

        // pre populate array of weighted values
        List<List<String>> weightedChars = new ArrayList<>(max + 1);
        for (int i = 0; i < max + 1; i++) {
            weightedChars.add(null);
        }

        // Populate weighted values containing list of chars per their occurrence
        for (int i = 0; i < occurrences.length; i++) {
            int weight = occurrences[i];
            if (weight > 0) {
                char charToAdd = (char) (i);
                if (weightedChars.get(weight) == null) {
                    weightedChars.set(weight, new ArrayList<>());
                }
                String charSequence = Stream.generate(() -> String.valueOf(charToAdd)).limit(weight).collect(Collectors.joining());
                weightedChars.get(weight).add(charSequence);
            }
        }

        // populate response from array of weighted values, traversing in descending order
        StringBuilder response = new StringBuilder();
        for (int i = weightedChars.size() - 1; i > 0; i--) {

            List<String> characters = weightedChars.get(i);
            if (characters != null)
                response.append(String.join("", characters));

        }
        return response.toString();
    }

}
