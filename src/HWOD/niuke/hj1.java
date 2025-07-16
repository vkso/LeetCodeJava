package HWOD.niuke;

import java.util.Scanner;

public class hj1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");

        System.out.println(split[split.length - 1].length());
    }
}
