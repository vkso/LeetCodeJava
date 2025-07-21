package HWOD.niuke;

import java.util.ArrayList;
import java.util.Scanner;

public class hj76 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int start = n * (n - 1) + 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(start + 2 * i);
            if (i != n - 1) {
                sb.append("+");
            }
        }

        System.out.println(sb.toString());
    }
}
