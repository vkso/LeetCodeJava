package HWOD.niuke;

import java.util.Scanner;

public class hj57 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(add(s1, s2));
    }

    public static String add(String s1, String s2) {
        StringBuilder res = new StringBuilder();

        int n = s1.length() - 1;
        int m = s2.length() - 1;

        int carry = 0;

        while (n >= 0 || m >= 0) {
            char c1 = n >= 0 ? s1.charAt(n--) : '0';
            char c2 = m >= 0 ? s2.charAt(m--) : '0';

            int sum = (c1 - '0') + (c2 - '0') + carry;
            res.append(sum % 10);
            carry = sum / 10;
        }

        if (carry == 1) {
            res.append(carry);
        }

        return res.reverse().toString();
    }
}
