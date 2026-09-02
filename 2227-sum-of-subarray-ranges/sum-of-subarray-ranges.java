class Solution {
    private int[] getNSEL(int arr[]) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
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

    private int[] getNSER(int arr[]) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
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

    private long minSubArrSum(int arr[]) {
        int NSEL[] = getNSEL(arr);
        int NSER[] = getNSER(arr);
        int n = arr.length;

        long result = 0;
        for (int i = 0; i < n; i++) {
            int l = i - NSEL[i];
            int r = NSER[i] - i;

            long minElSubCount = l * r;
            long minElSum = arr[i] * minElSubCount;
            result += minElSum;
        }

        return result;
    }

    private int[] getNGEL(int arr[]) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int nge[] = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            nge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return nge;
    }

    private int[] getNGER(int arr[]) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int nge[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nge;
    }

    private long maxSubArrSum(int arr[]) {
        int NGEL[] = getNGEL(arr);
        int NGER[] = getNGER(arr);
        int n = arr.length;

        long result = 0;
        for (int i = 0; i < n; i++) {
            int l = i - NGEL[i];
            int r = NGER[i] - i;

            long minElSubCount = l * r;
            long minElSum = arr[i] * minElSubCount;
            result += minElSum;
        }

        return result;
    }

    public long subArrayRanges(int[] nums) {
        return maxSubArrSum(nums) - minSubArrSum(nums);
    }
}