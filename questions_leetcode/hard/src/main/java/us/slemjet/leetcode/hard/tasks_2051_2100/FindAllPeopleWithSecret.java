package us.slemjet.leetcode.hard.tasks_2051_2100;

import java.util.*;

/**
 * 2092. Find All People With Secret
 */
public class FindAllPeopleWithSecret {

    /**
     * Use BFS approach
     * <p>
     * Time: O(m*(n + m))    -> 25.49%
     * Space:O(m*(n + m))    -> 73.53%
     */
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        Map<Integer, List<List<Integer>>> personsMeetings = new TreeMap<>();

        for (int[] meeting : meetings) {
            int time = meeting[2];
            int person1 = meeting[0];
            int person2 = meeting[1];
            personsMeetings.computeIfAbsent(person1, key -> new ArrayList<>()).add(List.of(person2, time));
            personsMeetings.computeIfAbsent(person2, key -> new ArrayList<>()).add(List.of(person1, time));
        }

        int[] timeToKnowSecret = new int[n];
        Arrays.fill(timeToKnowSecret, Integer.MAX_VALUE);
        timeToKnowSecret[0] = 0;
        timeToKnowSecret[firstPerson] = 0;

        Queue<List<Integer>> peopleWithSecretToProcess = new LinkedList<>();
        peopleWithSecretToProcess.offer(List.of(0, 0));
        peopleWithSecretToProcess.offer(List.of(firstPerson, 0));

        while (!peopleWithSecretToProcess.isEmpty()) {

            List<Integer> personAndTime = peopleWithSecretToProcess.poll();
            Integer person = personAndTime.get(0);
            Integer timeWhenKnowsSecret = personAndTime.get(1);

            // Get all meetings with other people when can pass the secret
            List<List<Integer>> meetingsWithOthers = personsMeetings.getOrDefault(person, new ArrayList<>());

            for (List<Integer> otherPersonTime : meetingsWithOthers) {
                Integer otherPerson = otherPersonTime.get(0);
                Integer timeOfMeeting = otherPersonTime.get(1);

                if (timeOfMeeting >= timeWhenKnowsSecret && timeToKnowSecret[otherPerson] > timeOfMeeting) {
                    // Gets secret from this meeting
                    timeToKnowSecret[otherPerson] = timeOfMeeting;
                    peopleWithSecretToProcess.offer(List.of(otherPerson, timeOfMeeting));
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        // Add all people who know the secret
        for (int i = 0; i < n; i++) {
            if (timeToKnowSecret[i] != Integer.MAX_VALUE) {
                result.add(i);
            }
        }

        return result;
    }
}
