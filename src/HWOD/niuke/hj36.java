package HWOD.niuke;

import java.util.HashSet;
import java.util.Scanner;

public class hj36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String template = sc.nextLine();
        String objStr = sc.next();

        char[] array = template.toCharArray();
        HashSet<Character> set = new HashSet<>();

        StringBuilder sb_template = new StringBuilder();
        for (char ch : array) {
            if (!set.contains(ch)) {
                sb_template.append(ch);
                set.add(ch);
            }
        }

        for (int i = 97; i <= 'z'; i++) {
            if (!set.contains((char) (i))) {
                sb_template.append((char)i);
            }
        }

        String originalAlphabet = "abcdefghijklmnopqrstuvwxyz";

        StringBuilder res = new StringBuilder();
        for (char ch : objStr.toCharArray()) {
            int index = originalAlphabet.indexOf(ch);
            res.append(sb_template.charAt(index));
        }

        System.out.println(res.toString());
    }
}
