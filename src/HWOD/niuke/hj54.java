package HWOD.niuke;

import java.util.Scanner;

public class hj54 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        String[] split = line.split(",");

        long res = Long.parseLong(split[split.length - 1]) - Long.parseLong(split[1]) - 1;
        System.out.println(res);
    }
}
