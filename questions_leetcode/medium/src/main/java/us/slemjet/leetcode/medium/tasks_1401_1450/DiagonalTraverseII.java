package us.slemjet.leetcode.medium.tasks_1401_1450;

import java.util.*;

/**
 * 1424. Diagonal Traverse II
 */
public class DiagonalTraverseII {


    /**
     * BFS
     *
     * Time: O(n) -> 49.02%
     * Space: O(sqrtn) -> 43.45%
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        List<Integer> resultList = new ArrayList<>();

        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            int row = next[0];
            int col = next[1];
            resultList.add(nums.get(row).get(col));

            if (col == 0 && row + 1 < nums.size()) {
                queue.offer(new int[]{row + 1, col});
            }

            if (col + 1 < nums.get(row).size()) {
                queue.offer(new int[]{row, col + 1});
            }
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Time limit exceeded
     */
    public int[] findDiagonalOrder2Loops(List<List<Integer>> nums) {

        List<Integer> resultList = new ArrayList<>();

        int maxSize = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j <= i; j++) {
                List<Integer> sublist = nums.get(i - j);
                maxSize = Math.max(maxSize, sublist.size());
                if (sublist.size() > j) {
                    Integer value = sublist.get(j);
                    resultList.add(value);
                }
            }
        }

        for (int i = 1; i < maxSize; i++) {
            for (int j = 0; j < nums.size(); j++) {
                List<Integer> sublist = nums.get(nums.size() - 1 - j);
                int idx = i + j;
                if (sublist.size() > idx) {
                    Integer value = sublist.get(idx);
                    resultList.add(value);
                }
            }
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Time Limit Exceeded
     */
    public int[] findDiagonalOrderMap(List<List<Integer>> nums) {

        Map<Integer, List<Integer>> diagonals = new LinkedHashMap<>();

        int maxLength = nums.stream().map(List::size).max(Comparator.naturalOrder()).orElse(0);

        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < nums.size(); j++) {
                List<Integer> row = nums.get(j);
                if (row.size() > i) {
                    Integer key = i + j;
                    diagonals.computeIfAbsent(key, newKey -> new ArrayList<>()).add(row.get(i));
                }
            }
        }

        List<Integer> resultList = new ArrayList<>();

        for (Integer key : diagonals.keySet()) {
            resultList.addAll(diagonals.get(key));
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
