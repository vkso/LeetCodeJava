package HWOD.niuke;

import java.util.Scanner;

public class Problem31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String[] split = line.split("[^a-zA-z]");

        StringBuilder sb = new StringBuilder();

        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].isEmpty()) continue;
            sb.append(split[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
