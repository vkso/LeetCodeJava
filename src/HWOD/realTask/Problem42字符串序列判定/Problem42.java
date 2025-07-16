package HWOD.realTask.Problem42字符串序列判定;

import java.util.Scanner;

public class Problem42 {
    /**
     * 字符串序列判定
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        String L = sc.nextLine();

        int index_s = 0;
        int index_l = 0;

        while (index_s < S.length() && index_l < L.length()) {
            if (S.charAt(index_s) == L.charAt(index_l)) {
                index_s++;
                index_l++;
            } else {
                index_l++;
            }
        }

        if (index_s == S.length()) {
            System.out.println(index_l - 1);
        } else {
            System.out.println(-1);
        }
    }
}
