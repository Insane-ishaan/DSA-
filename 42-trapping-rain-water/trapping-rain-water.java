class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int totalWater = 0;

        int leftMax = 0, rightMax = 0, waterStored = 0;

        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax > rightMax) {
                waterStored = rightMax - height[right--];
                totalWater += waterStored;
            } else {
                waterStored = leftMax - height[left++];
                totalWater += waterStored;
            }
        }

        return totalWater;
    }
}