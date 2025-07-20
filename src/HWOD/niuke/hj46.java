package HWOD.niuke;

import java.util.Scanner;

public class hj46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String objstr = sc.nextLine();
        int k = sc.nextInt();

        System.out.println(objstr.substring(0, k));
    }
}
