class EL implements Comparable<EL> {
    int value;
    int freq;

    public EL(int value,int freq) {
        this.value = value;
        this.freq = freq;
    }

    @Override
    public int compareTo(EL e2) {
        return e2.freq - this.freq;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int val : nums) {
            mp.put(val, mp.getOrDefault(val, 0) + 1);
        }

        PriorityQueue<EL> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int v = entry.getKey();
            int f = entry.getValue();
            pq.add(new EL(v, f));
        }

        int ans[] = new int[k];
        int i = 0;
        while (k-- > 0) {
            ans[i++] = pq.poll().value;
        }

        return ans;
    }
}