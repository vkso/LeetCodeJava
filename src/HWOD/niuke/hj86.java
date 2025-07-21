package HWOD.niuke;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hj86 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String binaryString = Integer.toBinaryString(n);

        Pattern compile = Pattern.compile("([1]{1,})");
        Matcher matcher = compile.matcher(binaryString);

        int maxLen = 0;
        while (matcher.find()) {
            String group = matcher.group();
            if (group.length() > maxLen) {
                maxLen = group.length();
            }
        }

        System.out.println(maxLen);
    }
}
