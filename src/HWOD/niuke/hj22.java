package HWOD.niuke;

import java.util.Scanner;

public class hj22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n == 0) {
                return;
            }

            int count = 0;

            while (n >= 2) {
                if (n == 2) {
                    count++;
                    break;
                }

                count += (n / 3);
                n = n / 3 + n % 3;
            }

            System.out.println(count);
        }
    }
}
