package HWOD.niuke;

import java.util.Scanner;

public class hj20 {

    /**
     * 1. 长度大于等于 8
     * 2. 至少包含 [大写字母]、[小写字母]、[数字]、[特殊字符]中的三种
     * 3. 不能包含两个长度大于 2 的相等子串
     * @param args
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            if (line.length() < 8) {
                System.out.println("NG");
                continue;
            }

            int upper = 0, lower = 0, number = 0, special = 0;
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (Character.isDigit(ch)) {
                    number = 1;
                    continue;
                }
                if (ch >= 'a' && ch <= 'z') {
                    lower = 1;
                    continue;
                }
                if (ch >= 'A' && ch <= 'Z') {
                    upper = 1;
                    continue;
                }
                special = 1;
            }

            if (upper + lower + number + special < 3) {
                System.out.println("NG");
                continue;
            }

            if (getString(line, 0, 3)) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }

    public static boolean getString(String str, int l, int r) {
        if (r >= str.length()) {
            return false;
        }
        if (str.substring(r).contains(str.substring(l, r))) {
            return true;
        } else {
            return getString(str, l + 1, r + 1);
        }
    }
}
