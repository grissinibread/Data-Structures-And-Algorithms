package hash;

import java.util.LinkedList;

public class HashTable {

    // KeyValuePair Class
    private class KeyValuePair {
        private String value;
        private int key;

        private KeyValuePair(int key, String value) {
            this.value = value;
            this.key = key;
        }

        @Override
        public String toString() {
            return "{Key: " + key + ", Value: " + value + '}';
        }
    }

    LinkedList<KeyValuePair>[] map = new LinkedList[5];

    // put(k,v)
    public void put(int k, String v) {
       var pair = getPair(k);
       if(pair != null) {
           pair.value = v;
           return;
       }

        getOrCreateBucket(k).add(new KeyValuePair(k, v));
    }

    // get(k) : v
    public String get(int k) {
        var pair = getPair(k);
        return (pair == null) ? null : pair.value;
    }

    // remove(k)
    public void remove(int key) {
        var pair = getPair(key);

        if(pair == null)
            throw new IllegalStateException();
        getBucket(key).remove(pair);
    }

    public void print() {
        for(var item : this.map)
            if(item != null)
                System.out.println(item.toString());

    }

    private KeyValuePair getPair(int key) {
        var bucket = getBucket(key);

        if(bucket != null) {
            for(var pair : bucket)
                if(pair.key == key)
                    return pair;
        }

        return null;
    }

    private LinkedList<KeyValuePair> getBucket(int k) {
        return this.map[getHash(k)];
    }

    private LinkedList<KeyValuePair> getOrCreateBucket(int key) {
        var index = getHash(key);
        var bucket = this.map[index];

        if(bucket == null)
            this.map[index] = new LinkedList<>();

        return bucket;
    }

    private int getHash(int k) {
        return k % this.map.length;
    }
}
