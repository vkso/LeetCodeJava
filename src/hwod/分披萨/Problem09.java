package hwod.分披萨;

import java.util.Arrays;
import java.util.Scanner;

public class Problem09 {
    /**
     * 分披萨：动态规划
     */
    static int n;  // 披萨数量
    static int[] a;  // 每块披萨的美味值
    static int[][] dp;  // 记忆化数组，用于存储已计算过的状态

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);    // 初始化记忆数组，将所有值设置为-1，表示未计算
        }

        int ans = 0;  // 初始化最大美味值
        // 遍历每一块披萨，尝试以每块披萨为起点计算出最大的值
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, allocation((i + 1) % n, (i + n - 1) % n) + a[i]);
        }

        System.out.println(ans);
    }

    public static int allocation(int L, int R) {
        if (dp[L][R] != -1) {
            return dp[L][R];
        }

        if (a[L] > a[R]) {
            L = (L + 1) % n;
        } else {
            R = (R + n - 1) % n;
        }

        if (L == R) {  // 只剩下最后一块的时候
            dp[L][R] = a[L];
        } else {
            dp[L][R] = Math.max(a[L] + allocation((L + 1) % n, R), a[R] + allocation(L, (R + n - 1) % n));
        }
        return dp[L][R];
    }
}
