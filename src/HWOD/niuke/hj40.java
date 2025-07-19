package HWOD.niuke;

import java.util.Scanner;

public class hj40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int alphabet = 0, space = 0, digital = 0, others = 0;

        for (char ch : line.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                alphabet++;
            } else if (Character.isDigit(ch)) {
                digital++;
            } else if (ch == ' ') {
                space++;
            } else {
                others++;
            }
        }

        System.out.println(alphabet);
        System.out.println(space);
        System.out.println(digital);
        System.out.println(others);
    }
}
