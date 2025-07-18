package HWOD.niuke;

import java.util.Scanner;

public class hj37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n <= 2) {
            System.out.println(1);
        }

        int[] count = new int[n];
        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i < n; i++) {
            count[i] = count[i - 1] + count[i - 2];
        }

        System.out.println(count[n - 1]);
    }
}
