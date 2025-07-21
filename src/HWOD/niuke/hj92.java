package HWOD.niuke;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hj92 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Pattern compile = Pattern.compile("(\\d+)");
        Matcher matcher = compile.matcher(s);

        int maxLen = 0;
        StringBuilder sb = new StringBuilder();

        ArrayList<String> list = new ArrayList<>();

        while (matcher.find()) {
            String group = matcher.group();
            list.add(group);
            if (group.length() > maxLen) {
                maxLen = group.length();
            }
        }

        for (String string : list) {
            if (string.length() == maxLen) {
                sb.append(string);
            }
        }

        System.out.println(sb.toString() + "," + maxLen);
    }
}
