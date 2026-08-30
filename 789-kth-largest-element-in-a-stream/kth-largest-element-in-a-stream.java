class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int K;
    public KthLargest(int k, int[] nums) {
        K=k;
        for(int num:nums){
            pq.offer(num);
        }
    }

    public int add(int val) {
        pq.offer(val);

        while(pq.size() > K){
            pq.poll();
        }

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */