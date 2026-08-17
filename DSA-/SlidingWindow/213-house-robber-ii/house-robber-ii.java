class Solution {
    int memo[];

    private int helper(int nums[], int i, int len) {
        if (i >= len) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int take = helper(nums, i + 2, len) + nums[i];
        int skip = helper(nums, i + 1, len);

        return memo[i] = Math.max(take, skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        int func1 = helper(nums, 0, n - 1);
        Arrays.fill(memo, -1);
        int func2 = helper(nums, 1, n);
        
        return Math.max(func1, func2);
    }
}