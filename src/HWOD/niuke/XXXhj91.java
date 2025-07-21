package HWOD.niuke;

import java.util.Scanner;

public class XXXhj91 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(dfs(0, 0, m, n));
    }

    public static int dfs(int i, int j, int m, int n) {
        if (i == m || j == n) {
            return 1;
        }
        return dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
    }
}
