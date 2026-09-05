class Pair {
    int value;
    int freq;

    public Pair(int value, int freq) {
        this.value = value;
        this.freq = freq;
    }
}

class StockSpanner {
    Stack<Pair> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!st.isEmpty() && st.peek().value <= price) {
            span += st.peek().freq;
            st.pop();
        }
        st.push(new Pair(price, span));

        return st.peek().freq;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */