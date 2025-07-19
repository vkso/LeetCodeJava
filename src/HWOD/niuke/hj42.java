package HWOD.niuke;

import java.util.Scanner;

public class hj42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        int step = b - a;
        System.out.println(b + step);
    }
}
