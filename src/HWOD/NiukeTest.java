package HWOD;

import java.util.Scanner;

public class NiukeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(new StringBuilder(s).reverse().toString());
    }
}
