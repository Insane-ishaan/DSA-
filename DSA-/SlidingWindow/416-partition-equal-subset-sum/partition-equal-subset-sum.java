class Solution {
    Boolean dp[][];

    private boolean isSubset(int[] nums, int i, int target) {
        if (0 == target) {
            return true;
        }

        if (target < 0 || i >= nums.length) {
            return false;
        }

        if (dp[i][target] != null) {
            return dp[i][target];
        }

        boolean take = isSubset(nums, i + 1, target - nums[i]);
        boolean skip = isSubset(nums, i + 1, target);

        return dp[i][target] = take || skip;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int val : nums) {
            sum += val;
        }

        dp = new Boolean[len][sum/2+1];

        if ((sum % 2) != 0) {
            return false;
        } else {
            if (isSubset(nums, 0, sum / 2)) {
                return true;
            } else {
                return false;
            }
        }
    }
}