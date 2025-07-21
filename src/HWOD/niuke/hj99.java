package HWOD.niuke;

import java.util.Scanner;

public class hj99 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;

        for (int i = 0; i <= n; i++) {
            if (isValid(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isValid(Integer number) {
        int numPower = number * number;
        return String.valueOf(numPower).endsWith(String.valueOf(number));
    }
}
