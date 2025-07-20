package HWOD.niuke;

import java.util.Scanner;

public class hj65 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        String shorter_str = s1.length() < s2.length() ? s1 : s2;
        String longer_str = s1.length() < s2.length() ? s2 : s1;

        int max = Integer.MIN_VALUE;
        String result = null;

        for (int i = 0; i < shorter_str.length(); i++) {
            for (int j = i; j < shorter_str.length() + 1; j++) {
                String substring = shorter_str.substring(i, j);

                if (longer_str.contains(substring) && substring.length() > max) {
                    max = substring.length();
                    result = substring;
                }

            }
        }

        System.out.println(result);
    }
}
