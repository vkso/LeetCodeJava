package HWOD.niuke;

import java.util.Scanner;
import java.util.regex.Pattern;

public class hj96 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        System.out.println(line.replaceAll("(\\d+)", "*$1*"));
    }
}
