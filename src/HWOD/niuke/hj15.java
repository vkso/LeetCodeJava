package HWOD.niuke;

import java.util.Scanner;

public class hj15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }

        System.out.println(count);
    }
}
