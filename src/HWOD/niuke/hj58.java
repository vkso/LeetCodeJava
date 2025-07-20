package HWOD.niuke;

import java.util.*;

public class hj58 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Integer> integers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            integers.add(sc.nextInt());
        }

        Collections.sort(integers);

        for (int i = 0; i < k; i++) {
            System.out.print(integers.get(i) + " ");
        }
    }
}
