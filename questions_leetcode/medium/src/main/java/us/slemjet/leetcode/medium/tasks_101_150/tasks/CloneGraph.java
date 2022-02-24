package us.slemjet.leetcode.medium.tasks_101_150.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 133. Clone Graph
 */
public class CloneGraph {

    /**
     * Runtime: 53.57%
     * Memory Usage: 5.18%
     */
    public Node cloneGraph(Node node) {
        if (node == null) return node;

        return clone(node, new Node[101]);
    }

    private Node clone(Node node, Node[] clones) {
        if (clones[node.val] != null) return clones[node.val];

        Node clone = new Node(node.val);
        clones[clone.val] = clone;

        if (node.neighbors != null) {
            clone.neighbors = node.neighbors.stream().map(node1 -> clone(node1, clones)).collect(Collectors.toList());
        }
        return clone;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }
}
