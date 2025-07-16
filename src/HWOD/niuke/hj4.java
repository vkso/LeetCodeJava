package HWOD.niuke;

import java.util.ArrayList;
import java.util.Scanner;

public class hj4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        ArrayList<String> list = new ArrayList<>();

        int start = 0;
        for (int i = 0; i + 8 <= str.length(); i += 8) {
            list.add(str.substring(i, i + 8));
            start = i + 8;
        }

        if (start != str.length()) {
            list.add(str.substring(start));
        }

        for (int i = 0; i < list.size() - 1; i++) {
            System.out.println(list.get(i));
        }

        String s = list.get(list.size() - 1);
        if (s.length() < 8) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = sb.length(); i < 8; i++) {
                sb.append("0");
            }
            System.out.println(sb.toString());
        } else {
            System.out.println(s);
        }
    }
}
