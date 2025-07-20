package HWOD.niuke;

import java.util.Scanner;

public class hj60 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a = 0, b = 0;
        int minus = Integer.MAX_VALUE;

        for (int i = 2; i <= n; i++) {
            if (!isSushu(i)) {
                continue;
            }
            for (int j = i; j <= n; j++) {
                if (!isSushu(j)) {
                    continue;
                }

                if (i + j == n && minus > j - i) {
                    a = i;
                    b = j;
                    minus = j - i;
                }

            }
        }
        System.out.println(a);
        System.out.println(b);
    }

    /**
     * 判断一个数是不是素数
     * @param n
     * @return
     */
    public static boolean isSushu(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
