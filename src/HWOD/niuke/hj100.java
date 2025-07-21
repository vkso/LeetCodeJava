package HWOD.niuke;

import java.util.Scanner;

public class hj100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(2);
            return;
        }

        int sum = 2;
        int curNum = 2;
        int step = 3;

        for (int i = 0; i < n - 1; i++) {
            curNum += step;
            sum += curNum;
        }

        System.out.println(sum);
    }
}
