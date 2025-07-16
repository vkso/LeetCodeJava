package HWOD.niuke;

import java.util.HashSet;
import java.util.Scanner;

public class hj10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            set.add(ch);
        }
        System.out.println(set.size());
    }
}
