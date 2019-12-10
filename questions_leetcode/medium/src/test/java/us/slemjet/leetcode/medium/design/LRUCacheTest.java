package us.slemjet.leetcode.medium.design;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LRUCacheTest {

    @Test
    void test1() {
        LRUCache cache = new LRUCache( 2);

        cache.put(1, 1);
        cache.put(2, 2);
        Assertions.assertThat(cache.get(1)).isEqualTo(1);
        cache.put(3, 3);
        Assertions.assertThat(cache.get(2)).isEqualTo(-1);
        cache.put(4, 4);
        Assertions.assertThat(cache.get(1)).isEqualTo(-1);
        Assertions.assertThat(cache.get(3)).isEqualTo(3);
        Assertions.assertThat(cache.get(4)).isEqualTo(4);
    }

    @Test
    void test2() {
        LRUCache cache = new LRUCache( 2);

        Assertions.assertThat(cache.get(2)).isEqualTo(-1);
        cache.put(2, 6);
        Assertions.assertThat(cache.get(1)).isEqualTo(-1);
        cache.put(1, 5);
        cache.put(1, 2);
        Assertions.assertThat(cache.get(1)).isEqualTo(2);
        Assertions.assertThat(cache.get(2)).isEqualTo(6);
    }

    @Test
    void test3() {
        LRUCache cache = new LRUCache( 2);

        Assertions.assertThat(cache.get(2)).isEqualTo(-1);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        Assertions.assertThat(cache.get(1)).isEqualTo(-1);
        Assertions.assertThat(cache.get(2)).isEqualTo(3);
    }
}
