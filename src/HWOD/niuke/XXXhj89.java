package HWOD.niuke;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XXXhj89 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String IP = sc.nextLine();

        String part = "(25[0-5]|2[0-4][0-9]|1\\d{2}|\\d|[1-9]\\d)";

        Pattern compile = Pattern.compile("^" + part + "\\." + part + "\\." + part + "\\." + part + "$");

        Matcher matcher = compile.matcher(IP);

        if (matcher.find()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
