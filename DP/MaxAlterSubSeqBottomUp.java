package DP;

public class MaxAlterSubSeqBottomUp {
    public long maxAlternatingSum(int nums[]) {
        int n = nums.length;
        long dp[][] = new long[n][2];

        dp[0][0] = 0;// even part
        dp[0][1] = nums[0];// odd length subsequences a nums[0] since one element subseq is also odd len

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] - nums[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + nums[i], dp[i - 1][1]);
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        MaxAlterSubSeqBottomUp obj = new MaxAlterSubSeqBottomUp();
        int nums[] = { 4, 2, 5, 3 };
        System.out.println(obj.maxAlternatingSum(nums));
    }
}
