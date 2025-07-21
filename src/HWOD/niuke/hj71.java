package HWOD.niuke;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hj71 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().toLowerCase();
        String p = sc.nextLine().toLowerCase();

        String replace = s.replace("*", "[0-9a-z]*").replace("?", "[0-9a-z]");
        replace = "^" + replace + "$";

        Pattern compile = Pattern.compile(replace);
        Matcher matcher = compile.matcher(p);

        boolean finded = matcher.find();

        if (finded) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
