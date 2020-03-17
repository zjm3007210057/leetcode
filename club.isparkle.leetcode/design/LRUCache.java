package design;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * medium
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * LRUCache cache = new LRUCache( 2 /capacity/ );
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 * Created by zjm on 2020/3/17 20:52
 */
public class LRUCache {

    private int capacity;
    private ListNode head;
    private ListNode tail;
    private Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
        map = new HashMap();
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        deleteNode(node);
        addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        ListNode node = map.get(key);
        if(node != null) {
            deleteNode(node);
            map.remove(key);
        }
        if(map.size() >= capacity) {
            map.remove(tail.pre.key);
            deleteNode(tail.pre);
        }
        ListNode newNode = new ListNode(key, value);
        map.put(key, newNode);
        addFirst(newNode);
    }

    private void deleteNode(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addFirst(ListNode node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    class ListNode {
        ListNode pre;
        ListNode next;
        private int key;
        private int value;
        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
