package HWOD.niuke;

import java.util.Scanner;

public class hj56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n < 6) {
            System.out.println(0);
            return;
        }

        int count = 0;

        for (int i = 6; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum == i) {
                count++;
            }
        }
        System.out.println(count);
    }
}
