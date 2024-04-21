package us.slemjet.leetcode.hard.tasks_2051_2100;

import us.slemjet.leetcode.common.UnionFind;

import java.util.*;

/**
 * 2092. Find All People With Secret
 */
public class FindAllPeopleWithSecret {

    /**
     * Use BFS approach - Queue
     * <p>
     * Time: O(m*(n + m))    -> 25.49%
     * Space:O(m*(n + m))    -> 73.53%
     */
    public List<Integer> findAllPeopleBFS(int n, int[][] meetings, int firstPerson) {

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

    /**
     * Use DFS approach - Stack
     * <p>
     * Time: O(m*(n + m))    -> 25.00%
     * Space:O(m*(n + m))    -> 89.00%
     */
    public List<Integer> findAllPeopleDFS(int n, int[][] meetings, int firstPerson) {

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

        Stack<List<Integer>> peopleWithSecretToProcess = new Stack<>();
        peopleWithSecretToProcess.push(List.of(0, 0));
        peopleWithSecretToProcess.push(List.of(firstPerson, 0));

        while (!peopleWithSecretToProcess.isEmpty()) {

            List<Integer> personAndTime = peopleWithSecretToProcess.pop();
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
                    peopleWithSecretToProcess.push(List.of(otherPerson, timeOfMeeting));
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

    /**
     * Use Union Find
     * <p>
     * Time: O(mlogm + n)    ->  47.00%
     * Space:O(m + n)        ->  18.00%
     */
    public List<Integer> findAllPeopleUnionFind(int n, int[][] meetings, int firstPerson) {

        // Sort asc by time
        Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting[2]));

        // Group by time and retain order
        Map<Integer, List<int[]>> meetingsByTime = new TreeMap<>();
        for (int[] meeting : meetings) {
            meetingsByTime.computeIfAbsent(meeting[2], integer -> new ArrayList<>()).add(new int[]{meeting[0], meeting[1]});
        }

        UnionFind unionFind = new UnionFind(n);
        unionFind.unite(0, firstPerson);

        // Process in order of increasing time
        meetingsByTime.forEach((time, sameTimeMeetings) -> {

            // Process all meeting for current time
            // Unite all participants pairs
            sameTimeMeetings.forEach(meeting ->
                    unionFind.unite(meeting[0], meeting[1]));

            sameTimeMeetings.forEach(meeting -> {
                // Since both participants are joined - it is enough to check one of them
                if (!unionFind.isConnected(0, meeting[0])) {
                    // Check if any participant is not connected to 0 - this means it will not know the secret so we disjoint them
                    unionFind.reset(meeting[0]);
                    unionFind.reset(meeting[1]);
                }
            });
        });

        List<Integer> result = new ArrayList<>();
        // Check which of the nodes are connected to 0 - this means that they know the secret
        for (int i = 0; i < n; i++) {
            if (unionFind.isConnected(0, i)) {
                result.add(i);
            }
        }

        return result;
    }
}
