package HWOD.niuke;

import java.util.Scanner;

public class hj6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextInt();
        long k = (long) Math.sqrt(num);

        for (long i = 2; i <= k; i++) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        System.out.println(num == 1 ? "" : num + " ");
    }
}
