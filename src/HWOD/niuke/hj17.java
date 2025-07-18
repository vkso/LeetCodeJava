package HWOD.niuke;

import java.util.Scanner;

public class hj17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(";");

        int x = 0, y = 0;

        for (String command : split) {
            if (command.length() < 2 || command.length() > 3) {
                continue;
            }

            char ch = command.charAt(0);

            if ("WSAD".indexOf(ch) < 0) {
                continue;
            }

            int step;

            try {
                step = Integer.parseInt(command.substring(1));
            } catch (Exception e) {
                continue;
            }

            if (ch == 'W') {  // ↑
                y += step;
            } else if (ch == 'S') {  // ↓
                y -= step;
            } else if (ch == 'A') {  // <--
                x -= step;
            } else if (ch == 'D') {  // -->
                x += step;
            }
        }

        System.out.println(x + "," + y);
    }
}
