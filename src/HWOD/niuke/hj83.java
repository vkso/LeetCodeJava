package HWOD.niuke;

import java.util.Scanner;

public class hj83 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long h = sc.nextInt();

        for (int i = 0; i < n; i++) {
            long x = sc.nextInt();
            long y = sc.nextInt();
            long z = sc.nextInt();

            long gdc = gdc(gdc(x, y), 2 * h - z);

            System.out.println(x / gdc + " " + y / gdc + " " + (2*h-z) / gdc);
        }
    }

    public static long gdc(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gdc(b, a % b);
    }
}
