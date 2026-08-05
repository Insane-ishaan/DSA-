package DP;
//LEETCODE 1335

public class MinDiffJobSch {
    private static int helper(int[] jobs, int n, int idx, int days) {
        if (days == 1) {
            int maxD = Integer.MIN_VALUE;
            for (int i = idx; i < n; i++) {
                maxD = Math.max(maxD, jobs[i]);
            }
            return maxD;
        }

        int maxD = Integer.MIN_VALUE;
        int finalResult = Integer.MAX_VALUE;

        for (int i = idx; i <= n - days; i++) {
            maxD = Math.max(maxD, jobs[i]);

                int result = maxD + helper(jobs, n, i + 1, days - 1);
            finalResult = Math.min(finalResult, result);
        }
        return finalResult;
    }

    public static void main(String[] args) {
        int[] jobDifficulty = { 1, 1, 1 };
        int d = 3;
        int len = jobDifficulty.length;
        if (len < d) {
            System.out.println("Invalid days");
            return;
        }

        System.out.println(helper(jobDifficulty, len, 0, d));

    }
}