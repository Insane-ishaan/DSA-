class Solution {
    private int[] getNSL(int arr[]) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int nse[] = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return nse;
    }

    private int[] getNSR(int arr[]) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int nse[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nse;
    }

    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        int NSL[] = getNSL(arr);
        int NSR[] = getNSR(arr);

        long result = 0;
        for (int i = 0; i < arr.length; i++) {
            long l = i - NSL[i];
            long r = NSR[i] - i;

            long totalWays = l * r;
            long minNumCount = (totalWays * arr[i]);
            result = (result + minNumCount) % MOD;
        }

        return (int) result;
    }
}