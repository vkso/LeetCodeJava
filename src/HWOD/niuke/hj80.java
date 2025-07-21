package HWOD.niuke;

import java.util.Scanner;
import java.util.TreeSet;

public class hj80 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            treeSet.add(sc.nextInt());
        }

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            treeSet.add(sc.nextInt());
        }

        for (Integer i : treeSet) {
            System.out.print(i);
        }
    }
}
