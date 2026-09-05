class Solution {
    private int getMaxArea(int[] h, int len) {
        Stack<Integer> st = new Stack<>();
        int[] NSL = new int[len];
        int[] NSR = new int[len];

        for (int i = 0; i < len; i++) {
            while (!st.isEmpty() && h[st.peek()] >= h[i]) {
                st.pop();
            }

            NSL[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!st.isEmpty() && h[st.peek()] >= h[i]) {
                st.pop();
            }

            NSR[i] = st.isEmpty() ? len : st.peek();
            st.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            int width = (NSR[i] - NSL[i]) - 1;
            int area = h[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int height[] = new int[m];
        for (int col = 0; col < m; col++) {
            if (matrix[0][col] == '0') {
                height[col] = 0;
            } else {
                height[col] = 1;
            }
        }

        int maxArea = getMaxArea(height, m);

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (matrix[row][col] == '0') {
                    height[col] = 0;
                } else {
                    height[col] += 1;
                }
            }

            maxArea = Math.max(maxArea, getMaxArea(height, m));
        }

        return maxArea;
    }
}