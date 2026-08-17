class Solution {
    int dp[][];

    private int helper(int[] ams, int idx, int am) {
        if (am == 0) {
            return 1;
        }

        if (idx >= ams.length) {
            return 0;
        }

        if (dp[idx][am] != -1) {
            return dp[idx][am];
        }

        if (am < ams[idx]) {
            return helper(ams, idx + 1, am);
        }

        int take = helper(ams, idx, am - ams[idx]);
        int skip = helper(ams, idx + 1, am);

        return dp[idx][am] = take + skip;
    }

    public int change(int amount, int[] coins) {
        int len = coins.length;
        dp = new int[len + 1][amount + 1];

        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }

        return helper(coins, 0, amount);
    }
}