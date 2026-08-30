class MedianFinder {
    PriorityQueue<Integer> firstHalf;
    PriorityQueue<Integer> secondHalf;

    public MedianFinder() {
        firstHalf = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        secondHalf = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (firstHalf.isEmpty() && secondHalf.isEmpty()) {
            firstHalf.offer(num);
        } else if (firstHalf.peek() < num) {
            secondHalf.offer(num);
        } else {
            firstHalf.offer(num);
        }

        if (firstHalf.size() - secondHalf.size() > 1) {
            secondHalf.offer(firstHalf.poll());
        } else if (secondHalf.size() - firstHalf.size() >= 1) {
            firstHalf.offer(secondHalf.poll());
        }
    }

    public double findMedian() {
        if (firstHalf.size() == secondHalf.size()) {
            return (double) (secondHalf.peek() + firstHalf.peek()) / 2;
        } else {
            return firstHalf.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */