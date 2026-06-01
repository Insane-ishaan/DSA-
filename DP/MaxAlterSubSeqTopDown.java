package DP;

import java.util.*;

public class MaxAlterSubSeqTopDown {
    int n;
    long dp[][];

    public long helper(int nums[], int i, boolean flag) {
        if (i >= n) {
            return 0;
        }

        int f = flag ? 1 : 0;
        if (dp[i][f] != -1) {
            return dp[i][f];
        }

        int val = nums[i];
        if (!flag) {
            val = -val;
        }
        long take = helper(nums, i + 1, !flag) + val;
        long skip = helper(nums, i + 1, flag);
        return dp[i][f] = Math.max(skip, take);
    }

    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        dp = new long[n][2];

        for (long temp[] : dp) {
            Arrays.fill(temp, -1);
        }

        return helper(nums, 0, true);
    }

    public static void main(String[] args) {
        MaxAlterSubSeqTopDown alt = new MaxAlterSubSeqTopDown();
        int nums[] = { 4, 2 };
        System.out.println(alt.maxAlternatingSum(nums));
    }
}
