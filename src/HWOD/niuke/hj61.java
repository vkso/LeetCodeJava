package HWOD.niuke;

import java.util.Scanner;

public class hj61 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // 苹果数
        int n = sc.nextInt(); // 盘子数
        System.out.println(countWays(m, n));
    }

    private static int countWays(int m, int n) {
        if (m == 0) return 1;
        if (n == 0) return 0;
        if (m < n) {
            return countWays(m, m);
        }
        return countWays(m - n, n) + countWays(m, n - 1);
    }
}
