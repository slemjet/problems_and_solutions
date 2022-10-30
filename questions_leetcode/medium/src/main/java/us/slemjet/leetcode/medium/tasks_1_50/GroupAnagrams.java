package us.slemjet.leetcode.medium.tasks_1_50;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 49. Group Anagrams
 */
public class GroupAnagrams {

    /**
     * Runtime: 62.30%
     * Memory Usage: 67.32%
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> strsByOccurrence = new HashMap<>();

        for (String str : strs) {
            int[] occurrences = new int[26];

            for (char aChar : str.toCharArray()) {
                int idx = aChar - 'a';
                occurrences[idx]++;
            }

            StringBuilder key = new StringBuilder();

            for (int i = 0; i < occurrences.length; i++) {
                if (occurrences[i] > 0) {
                    char aChar = (char) ('a' + i);
                    key.append(aChar).append(occurrences[i]);
                }
            }

            String keyStr = key.toString();
            List<String> strsForOccurrence = strsByOccurrence.getOrDefault(keyStr, new ArrayList<>());
            strsForOccurrence.add(str);
            strsByOccurrence.put(keyStr, strsForOccurrence);
        }

        return new ArrayList<>(strsByOccurrence.values());
    }

    /**
     * Runtime: 20.13%
     * Memory Usage: 36.61%
     */
    public List<List<String>> groupAnagramsList(String[] strs) {

        Map<List<Integer>, List<String>> strsByOccurrence = new HashMap<>();

        for (String str : strs) {
            int[] occurrences = new int[26];

            for (char aChar : str.toCharArray()) {
                int idx = aChar - 'a';
                occurrences[idx]++;
            }

            List<Integer> key = Arrays.stream(occurrences).boxed().collect(Collectors.toList());

            List<String> strsForOccurrence = strsByOccurrence.getOrDefault(key, new ArrayList<>());
            strsForOccurrence.add(str);
            strsByOccurrence.put(key, strsForOccurrence);
        }

        return new ArrayList<>(strsByOccurrence.values());
    }

    /**
     * Runtime: 42.80%
     * Memory Usage: 48.94%
     */
    public List<List<String>> groupAnagramsList2(String[] strs) {

        Map<List<Integer>, List<String>> strsByOccurrence = new HashMap<>();

        for (String str : strs) {
            List<Integer> key = Arrays.asList(new Integer[26]);
            for (char aChar : str.toCharArray()) {
                int idx = aChar - 'a';

                Integer value = key.get(idx);
                if (value == null) {
                    value = 0;
                }
                key.set(idx, ++value);
            }

            List<String> strsForOccurrence = strsByOccurrence.getOrDefault(key, new ArrayList<>());
            strsForOccurrence.add(str);
            strsByOccurrence.put(key, strsForOccurrence);
        }

        return new ArrayList<>(strsByOccurrence.values());
    }
}
