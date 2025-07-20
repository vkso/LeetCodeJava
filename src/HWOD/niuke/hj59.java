package HWOD.niuke;

import java.util.Scanner;

public class hj59 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] array = sc.nextLine().toCharArray();

        int[] count = new int[26];

        for (char ch : array) {
            count[ch - 'a']++;
        }

        for (char ch : array) {
            if (count[ch - 'a'] == 1) {
                System.out.println(ch);
                return;
            }
        }

        System.out.println(-1);
    }
}
