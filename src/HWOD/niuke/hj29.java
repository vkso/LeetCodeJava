package HWOD.niuke;

import java.util.Scanner;

public class hj29 {
    public static void main(String[] args) {
        String from = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String to   = "BCDEFGHIJKLMNOPQRSTUVWXYZAbcdefghijklmnopqrstuvwxyza1234567890";

        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < line1.length(); i++) {
            char ch = line1.charAt(i);
            sb1.append(to.charAt(from.indexOf(ch)));
        }

        System.out.println(sb1);

        StringBuilder sb2 = new StringBuilder();
        for (int j = 0; j < line2.length(); j++) {
            char ch = line2.charAt(j);
            sb2.append(from.charAt(to.indexOf(ch)));
        }

        System.out.println(sb2);
    }
}
