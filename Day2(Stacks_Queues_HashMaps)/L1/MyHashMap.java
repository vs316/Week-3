package DSA.HashMaps;

import java.util.LinkedList;

public class MyHashMap<K, V> {

    // Nested Entry class to hold key-value pairs
    private static class Entry<K, V> {

        K key;
        V value;
        Entry<K, V> next; // For chaining in the bucket

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private LinkedList<Entry<K, V>>[] buckets;

    public MyHashMap() {
        this.capacity = 16; // A default capacity
        buckets = new LinkedList[capacity];
        // Initialize each bucket with an empty LinkedList
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Compute bucket index based on key's hashCode
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        // Check if key already exists in the bucket. If yes, update its value.
        for (Entry<K, V> entry : buckets[bucketIndex]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        // Key does not exist, so add a new entry.
        buckets[bucketIndex].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        // Search for the key in its bucket.
        for (Entry<K, V> entry : buckets[bucketIndex]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Not found
    }

    public boolean remove(K key) {
        int bucketIndex = getBucketIndex(key);
        var iterator = buckets[bucketIndex].iterator();
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if (entry.key.equals(key)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("cherry", 30);
        System.out.println("banana -> " + map.get("banana")); // prints 20
        map.remove("banana");
        System.out.println("banana -> " + map.get("banana")); // prints null
    }
}
