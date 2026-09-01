class Solution {
    public long subArrayRanges(int[] nums) {
        long result = 0;
        int maxVal;
        int minVal;
        for (int i = 0; i < nums.length; i++) {
            minVal = nums[i];
            maxVal = nums[i];

            for (int j = i; j < nums.length; j++) {
                maxVal = Math.max(maxVal, nums[j]);
                minVal = Math.min(minVal, nums[j]);

                result += (maxVal - minVal);
            }
        }

        return result;
    }
}