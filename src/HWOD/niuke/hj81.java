package HWOD.niuke;

import java.util.HashSet;
import java.util.Scanner;

public class hj81 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();

        HashSet<Character> set = new HashSet<>();

        for (char ch : t.toCharArray()) {
            set.add(ch);
        }

        for (char ch : s.toCharArray()) {
            if (!set.contains(ch)) {
                System.out.println("false");
                return;
            }
        }

        System.out.println("true");
    }
}
