class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> mp = new HashMap<>();
        int result[] = new int[n];

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            int nge = st.isEmpty() ? -1 : st.peek();
            mp.put(nums2[i], nge);

            st.push(nums2[i]);
        }

        int idx = 0;
        for (int num : nums1) {
            if (mp.containsKey(num)) {
                result[idx] = mp.get(num);
            }
            idx++;
        }

        return result;
    }
}