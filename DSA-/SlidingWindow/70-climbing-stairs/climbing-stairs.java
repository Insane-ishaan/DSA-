class Solution {
    int memo[];

    private int helper(int n) {
        if (n < 0) {
            return 0;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        if (n == 0) {
            return 1;
        }

        int take1 = helper(n - 1);
        int take2 = helper(n - 2);

        return memo[n] = take1 + take2;
    }

    public int climbStairs(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return helper(n);
    }
}