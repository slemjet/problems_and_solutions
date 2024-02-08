package us.slemjet.leetcode.hard.tasks_651_700;

import java.util.*;

/**
 * 675. Cut Off Trees for Golf Event
 */
public class CutOffTreesForGolfEvent {

    /**
     * Add all nodes to List, sort
     * Calculate all paths between each 2 nodes from [0,0] to first in the list and then each in the list in ascending order
     * <p>
     * Runtime: 13.86%
     * Memory Usage: 16.95%
     */
    public int cutOffTree(List<List<Integer>> forest) {

        List<int[]> trees = new ArrayList<>();

        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                if (forest.get(i).get(j) > 1) trees.add(new int[]{i, j, forest.get(i).get(j)});
            }
        }

        int result = 0;
        trees.sort(Comparator.comparingInt(o -> o[2]));

        int[] curr = new int[]{0, 0, forest.get(0).get(0)};
        for (int[] next : trees) {
            int path = calculatePathBfs(curr, next, forest);
            if (path < 0) return -1;
            result += path;
            curr = next;
        }

        return result;
    }

    private int calculatePathBfs(int[] start, int[] end, List<List<Integer>> forest) {
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int step = 0;
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == end[0] && curr[1] == end[1]) return step;

                for (int[] d : dir) {
                    int nextI = curr[0] + d[0];
                    int nextJ = curr[1] + d[1];
                    if (nextI < 0 || nextI >= forest.size() || nextJ < 0 || nextJ >= forest.get(0).size()
                            || forest.get(nextI).get(nextJ) == 0 || visited[nextI][nextJ]) continue;
                    queue.add(new int[]{nextI, nextJ});
                    visited[nextI][nextJ] = true;
                }
            }
            step++;
        }

        return -1;
    }

    /**
     * Go From 2 sides for each path calculation
     *
     * Runtime: 14.00%
     * Memory Usage: 13.58%
     */
    public int cutOffTree2(List<List<Integer>> forest) {

        List<int[]> trees = new ArrayList<>();

        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                if (forest.get(i).get(j) > 1) trees.add(new int[]{i, j, forest.get(i).get(j)});
            }
        }

        int result = 0;
        trees.sort(Comparator.comparingInt(o -> o[2]));

        int[] curr = new int[]{0, 0, forest.get(0).get(0)};
        for (int[] next : trees) {
            int path = calculatePathBfs2(curr, next, forest);
            if (path < 0) return -1;
            result += path;
            curr = next;
        }

        return result;
    }

    private int calculatePathBfs2(int[] start, int[] end, List<List<Integer>> forest) {
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int minPath = Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]); // Min path that can be. No need to check if less than
        int startMove = 0;
        Queue<int[]> queueStart = new LinkedList<>();
        queueStart.add(start);
        boolean[][] visitedStart = new boolean[forest.size()][forest.get(0).size()];
        visitedStart[start[0]][start[1]] = true;

        int endMove = 0;
        Queue<int[]> queueEnd = new LinkedList<>();
        queueEnd.add(end);
        boolean[][] visitedEnd = new boolean[forest.size()][forest.get(0).size()];
        visitedEnd[end[0]][end[1]] = true;

        while (!queueStart.isEmpty() && !queueEnd.isEmpty()) {

            if (startMove + endMove >= minPath) {
                if (queueStart.stream().anyMatch(startVal -> queueEnd.stream().anyMatch(endVal -> (startVal[2] == endVal[2]))))
                    return startMove + endMove;
            }
            // Move start
            moveQueue(forest, dir, visitedStart, queueStart);
            startMove++;
            if (startMove + endMove >= minPath) {
                if (queueStart.stream().anyMatch(startVal -> queueEnd.stream().anyMatch(endVal -> (startVal[2] == endVal[2]))))
                    return startMove + endMove;
            }

            // Move end
            moveQueue(forest, dir, visitedEnd, queueEnd);
            startMove++;
            if (startMove + endMove >= minPath) {
                if (queueStart.stream().anyMatch(startVal -> queueEnd.stream().anyMatch(endVal -> (startVal[2] == endVal[2]))))
                    return startMove + endMove;
            }
        }
        return -1;
    }

    private void moveQueue(List<List<Integer>> forest, int[][] dir, boolean[][] visited, Queue<int[]> queueStart) {
        int size = queueStart.size();
        for (int i = 0; i < size; i++) {
            int[] curr = queueStart.poll();

            for (int[] d : dir) {
                int nextI = curr[0] + d[0];
                int nextJ = curr[1] + d[1];
                if (nextI < 0 || nextI >= forest.size() || nextJ < 0 || nextJ >= forest.get(0).size()
                        || forest.get(nextI).get(nextJ) == 0 || visited[nextI][nextJ]) continue;
                queueStart.add(new int[]{nextI, nextJ, forest.get(nextI).get(nextJ)});
                visited[nextI][nextJ] = true;
            }
        }
    }


    /**
     * Time limit exceeded
     */
    public int cutOffTree3(List<List<Integer>> forest) {

        int steps = 0;

        Map<Integer, List<Integer>> tree = new TreeMap<>();

        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                Integer currNode = forest.get(i).get(j);
                if (currNode == 0) continue;
                tree.computeIfAbsent(currNode, val -> new ArrayList<>());
                if (j > 0 && forest.get(i).get(j - 1) != 0) tree.get(currNode).add(forest.get(i).get(j - 1));
                if (j < forest.get(i).size() - 1 && forest.get(i).get(j + 1) != 0)
                    tree.get(currNode).add(forest.get(i).get(j + 1));
                if (i > 0 && forest.get(i - 1).get(j) != 0) tree.get(currNode).add(forest.get(i - 1).get(j));
                if (i < forest.size() - 1 && forest.get(i + 1).get(j) != 0)
                    tree.get(currNode).add(forest.get(i + 1).get(j));
            }
        }

        Integer start = forest.get(0).get(0);
        Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
        for (Integer node : tree.keySet()) {
            if (node == 1) continue;
            if (start != null) {
                // BFS until end node is reached
                int currSteps = getSteps(tree, start, node, memo);
                if (currSteps == -1) return -1;
                else steps += currSteps;
            }
            start = node;
        }
        return steps;
    }

    private int getSteps(Map<Integer, List<Integer>> tree, Integer start, int end, Map<Integer, Map<Integer, Integer>> memo) {
        if (memo.get(start) != null && memo.get(start).get(end) != null) {
            Integer steps = memo.get(start).get(end);
            return steps;
        }
        if (memo.get(end) != null && memo.get(end).get(start) != null) {
            Integer steps = memo.get(end).get(start);
            return steps;
        }
        int steps = 0;
        Queue<Integer> nodes = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        nodes.offer(start);

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                Integer poll = nodes.poll();
                if (visited.contains(poll)) continue;
                visited.add(poll);
                if (!memo.containsKey(start)) memo.put(poll, new HashMap<>());
                memo.get(start).putIfAbsent(poll, steps);

                if (poll == end) {
                    return steps;
                }
                List<Integer> candidates = tree.get(poll);
                if (candidates != null)
                    candidates.stream().filter(val -> !visited.contains(val)).forEach(nodes::add);
            }
            steps++; // Make 1 step
        }
        return -1;
    }
}
