package HWOD.niuke;

import java.util.Scanner;

public class hj75 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();

        int maxLen = 0;

        for (int i = 0; i < t.length(); i++) {
            for (int j = i; j < t.length() + 1; j++) {
                String substring = t.substring(i, j);
                if (s.contains(substring) && substring.length() > maxLen) {
                    maxLen = substring.length();
                }
            }
        }

        System.out.println(maxLen);
    }
}
