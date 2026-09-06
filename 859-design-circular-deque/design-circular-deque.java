class MyCircularDeque {
    ArrayDeque<Integer> dq;
    int K;

    public MyCircularDeque(int k) {
        dq = new ArrayDeque<>();
        K = k;
    }

    public boolean insertFront(int value) {
        if (dq.size() < K) {
            dq.offerFirst(value);
            return true;
        }

        return false;
    }

    public boolean insertLast(int value) {
        if (dq.size() < K) {
            dq.offerLast(value);
            return true;
        }

        return false;
    }

    public boolean deleteFront() {
        if (dq.isEmpty()) {
            return false;
        }

        dq.pollFirst();
        return true;
    }

    public boolean deleteLast() {
        if (dq.isEmpty()) {
            return false;
        }

        dq.pollLast();
        return true;
    }

    public int getFront() {
        if (dq.isEmpty()) {
            return -1;
        }

        return dq.peekFirst();
    }

    public int getRear() {
        if (dq.isEmpty()) {
            return -1;
        }

        return dq.peekLast();
    }

    public boolean isEmpty() {
        return dq.isEmpty();
    }

    public boolean isFull() {
        return dq.size() == K;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */