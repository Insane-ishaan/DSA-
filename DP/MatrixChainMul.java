package DP;

/// Top DOwn
public class MatrixChainMul {
    public static int logic(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost1 = logic(arr, i, k);// arr[i-1]*arr[k]
            int cost2 = logic(arr, k + 1, j);// arr[k]*arr[j]
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            ans = Math.min(ans, cost1 + cost2 + cost3);
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30 };
        System.out.println(logic(arr, 1, arr.length - 1));
    }
}

/*
 * Tabulation
 * class Solution {
 * static int matrixMultiplication(int arr[]) {
 * int n = arr.length;
 * int dp[][] = new int[n][n];
 * 
 * for (int len = 2; len<n; len++) {
 * for (int i = 1; i + len - 1<n; i++) {
 * int j = i + len - 1;
 * dp[i][j] = Integer.MAX_VALUE;
 * for (int k = i; k<j; k++) {
 * int cost1 = dp[i][k];
 * int cost2 = dp[k + 1][j];
 * int cost3 = arr[i - 1]*arr[k]*arr[j];
 * dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);
 * }
 * }
 * }
 * 
 * return dp[1][n - 1];
 * }
 * }
 * 
 * 
 */