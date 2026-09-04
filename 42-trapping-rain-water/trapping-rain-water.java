class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = height[0];
        int LGE[] = new int[n];
        LGE[0] = leftMax;
        int rightMax = height[n - 1];
        int RGE[] = new int[n];
        RGE[n - 1] = rightMax;

        for (int i = 1; i < n; i++) {
            leftMax = Math.max(leftMax, height[i]);
            LGE[i] = leftMax;
        }

        for (int i = n - 2; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            RGE[i] = rightMax;
        }

        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int Boundary = Math.min(LGE[i], RGE[i]);
            int waterHolds = Boundary - height[i];
            totalWater += waterHolds;
        }

        return totalWater;
    }
}