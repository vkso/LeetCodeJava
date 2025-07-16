package HWOD.niuke;

import java.util.Scanner;
import java.util.TreeSet;

public class hj3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            treeSet.add(x);
        }

        while (!treeSet.isEmpty()) {
            System.out.println(treeSet.pollFirst());
        }
    }
}
