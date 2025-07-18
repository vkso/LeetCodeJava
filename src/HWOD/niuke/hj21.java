package HWOD.niuke;

import java.util.Scanner;

public class hj21 {
    /**
     * abc -> 2
     * def -> 3
     * ghi -> 4
     * jkl -> 5
     * mno -> 6
     * pqrs -> 7
     * tuv -> 8
     * wxyz -> 9
     * [A-Y] -> + 32 + 1
     * Z -> 97
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            StringBuilder sb = new StringBuilder();

            char[] array = line.toCharArray();
            for (char ch : array) {
                if (Character.isDigit(ch)) {
                    sb.append(ch);
                } else if (ch >= 'A' && ch <= 'Y') {
                    sb.append((char) (ch + 33));
                } else if (ch == 'Z') {
                    sb.append('a');
                } else {
                    sb.append(lowerToNum(ch));
                }
            }
            System.out.println(sb);
        }
    }

    public static char lowerToNum(char ch) {
        if ("abc".indexOf(ch) != -1) {
            return '2';
        } else if ("def".indexOf(ch) != -1) {
            return '3';
        } else if ("ghi".indexOf(ch) != -1) {
            return '4';
        } else if ("jkl".indexOf(ch) != -1) {
            return '5';
        } else if ("mno".indexOf(ch) != -1) {
            return '6';
        } else if ("pqrs".indexOf(ch) != -1) {
            return '7';
        } else if ("tuv".indexOf(ch) != -1) {
            return '8';
        } else if ("wxyz".indexOf(ch) != -1) {
            return '9';
        }
        return 'x';
    }
}
