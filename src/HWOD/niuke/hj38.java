package HWOD.niuke;

import java.util.Scanner;

public class hj38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        double h = (double) x;

        double[] hs = new double[6];

        hs[0] = h;

        for (int i = 1; i < 6; i++) {
            hs[i] = hs[i - 1] / 2;
        }

        double length = h;

        for (int i = 1; i < 5; i++) {
            length += hs[i] * 2;
        }

        System.out.println(length);
        System.out.println(hs[5]);
    }
}
