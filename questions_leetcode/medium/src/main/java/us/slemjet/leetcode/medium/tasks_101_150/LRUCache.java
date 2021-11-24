package us.slemjet.leetcode.medium.tasks_101_150;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * 146. LRU Cache
 *
 * Runtime: 99.87%
 * Memory: 65.03%
 */
public class LRUCache {

    private LinkedHashMap<Integer, Integer> storage;
    public LRUCache(final int capacity) {
        storage = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) { // we need to set true to access order
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity; // when to remove oldest entry
            }
        };
    }

    public int get(int key) {
        return storage.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        storage.put(key, value);
    }
}
