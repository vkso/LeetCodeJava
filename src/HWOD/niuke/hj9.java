package HWOD.niuke;

import java.util.HashSet;
import java.util.Scanner;

public class hj9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        StringBuilder reverse = new StringBuilder(line).reverse();

        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < reverse.length(); i++) {
            char ch = reverse.charAt(i);
            if (!set.contains(ch)) {
                sb.append(ch);
                set.add(ch);
            }
        }
        System.out.println(sb);
    }
}
