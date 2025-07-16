package HWOD.niuke;

import java.util.Scanner;

public class hj5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numStr = sc.nextLine();
        char[] charArray = numStr.substring(2).toCharArray();

        // 0 1 2 - 9 A   B  C  D  E  F
        //           10 11 12 13 14 15
        // ch - 'A' + 10;

        double position = 0;
        double sum = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            char ch = charArray[i];
            double value;
            if (Character.isDigit(ch)) {
                value = (ch - '0');
            } else {
                value = (ch - 'A') + 10;
            }
            sum += value * Math.pow((double) 16, position++);
        }
        System.out.println((int) sum);
    }
}
