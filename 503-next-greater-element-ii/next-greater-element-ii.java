class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int result[] = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }

            int nge = st.isEmpty() ? -1 : st.peek();
            result[i % n] = nge;

            st.push(nums[i % n]);
        }

        return result;
    }
}