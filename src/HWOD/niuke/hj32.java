package HWOD.niuke;

import java.util.Scanner;

public class hj32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        if (line.length() == 1) {
            System.out.println(1);
            return;
        }

        int maxRes = 0;
        for (int i = 0; i < line.length() - 1; i++) {
            for (int j = i + 1; j < line.length() + 1; j++) {
                String substring = line.substring(i, j);
                if (check(substring)) {
                    maxRes = Math.max(maxRes, j - i);
                }
            }
        }

        System.out.println(maxRes);
    }

    public static boolean check(String str) {

        if (str.length() == 1) {
            return true;
        }

        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            char front = str.charAt(i);
            char end = str.charAt(j);

            if (front != end) {
                return false;
            }
        }

        return true;
    }
}
