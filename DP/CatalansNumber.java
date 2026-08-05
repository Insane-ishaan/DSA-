package DP;

public class CatalansNumber {
    private static int logic(int n) {
        if (n <= 1) {
            return 1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += logic(i) * logic((n - 1) - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(logic(3));
    }
}