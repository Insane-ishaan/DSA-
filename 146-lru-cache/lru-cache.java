class LRUCache {
    LinkedHashMap<Integer, Integer> mp;
    int C;

    public LRUCache(int capacity) {
        mp = new LinkedHashMap<>();
        C = capacity;
    }

    public int get(int key) {
        if (!mp.containsKey(key)) {
            return -1;
        }

        int value = mp.get(key);
        mp.remove(key);
        mp.put(key, value);
        return mp.get(key);
    }

    public void put(int key, int value) {
        if(mp.containsKey(key)){
            mp.remove(key);
        }
        
        if (mp.size() >= C) {
            int k = mp.keySet().iterator().next();
            mp.remove(k);
        }
        mp.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */