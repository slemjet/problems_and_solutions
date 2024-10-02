package us.slemjet.leetcode.hard.tasks_401_450;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 432. All O`one Data Structure
 * </p>
 * Time: O(1)   ->  52.74%
 * Space:O(n)   ->  7.92%
 */
public class AllOOneDataStructure {

    Node head;
    Node tail;
    Map<String, Node> map;

    public AllOOneDataStructure() {

        map = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node currNode = map.get(key);
            int currFrequency = currNode.frequency;
            currNode.keys.remove(key); // Need to move this key to next node

            Node nextNode = currNode.next; // get a node with next frequency
            if (nextNode == tail || nextNode.frequency != currFrequency + 1) {
                // Need to create a new node and insert between
                Node newNode = createNewNode(key, currFrequency + 1, currNode, nextNode);
                map.put(key, newNode);
            } else {
                // Just add a current word key to a node with +1 frequency and replace value in map
                nextNode.keys.add(key);
                map.put(key, nextNode);
            }

            if (currNode.keys.isEmpty()) {
                // Need to remove a node
                removeNode(currNode);
            }
        } else {
            // Add a new node with initial frequency 1
            Node firstNode = head.next;
            if (firstNode == tail || firstNode.frequency > 1) {
                // No node with frequency 1 exists - need to create it
                Node newNode = createNewNode(key, 1, head, firstNode);
                map.put(key, newNode);
            } else {
                firstNode.keys.add(key);
                map.put(key, firstNode);
            }
        }
    }

    public void dec(String key) {
        if (!map.containsKey(key)) {
            return;
        }

        Node currNode = map.get(key);
        currNode.keys.remove(key); // need to move this key to prev node
        int currFrequency = currNode.frequency;

        if (currFrequency == 1) {
            map.remove(key);
        } else {
            Node prevNode = currNode.prev;
            if (prevNode == head || prevNode.frequency != currFrequency - 1) {
                Node newNode = createNewNode(key, currFrequency - 1, prevNode, currNode);
                map.put(key, newNode);
            } else {
                prevNode.keys.add(key);
                map.put(key, prevNode);
            }
        }

        if (currNode.keys.isEmpty()) {
            removeNode(currNode);
        }

    }

    public String getMaxKey() {
        if (tail.prev == head) {
            // No nodes in between
            return "";
        }

        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }

        return head.next.keys.iterator().next();
    }

    private static Node createNewNode(String key, int frequency, Node prev, Node next) {
        Node newNode = new Node(frequency);
        newNode.prev = prev;
        newNode.next = next;
        next.prev = newNode;
        prev.next = newNode;
        newNode.keys.add(key);
        return newNode;
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    static class Node {
        int frequency;
        Node next;
        Node prev;
        Set<String> keys = new HashSet<>();

        public Node(int frequency) {
            this.frequency = frequency;
        }
    }
}
