package HWOD.niuke;

import java.util.Arrays;
import java.util.Scanner;

public class hj34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        char[] array = line.toCharArray();

        Arrays.sort(array);

        StringBuilder sb = new StringBuilder();
        for (char ch : array) {
            sb.append(ch);
        }

        System.out.println(sb.toString());
    }
}
