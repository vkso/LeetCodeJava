package HWOD.niuke;

import java.util.Scanner;

public class hj7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String[] split = s.split("\\.");

        if (split.length == 1) {
            System.out.println(Integer.parseInt(split[0]));
            return;
        }

        int left = Integer.parseInt(split[0]);
        int right = split[1].charAt(0) - '0';

        if (right >= 5) {
            System.out.println(left + 1);
        } else {
            System.out.println(left);
        }
    }
}
