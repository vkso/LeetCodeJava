package HWOD.niuke;

import java.util.*;

public class hj41 {
    /**
     * 1 1 2
     * 0 1 2 3 4
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] weights = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] nums = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        // 全部的砝码
        ArrayList<Integer> parts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nums[i]; j++) {
                parts.add(weights[i]);
            }
        }

        HashSet<Integer> dp = new HashSet<>();
        dp.add(0);

        for (Integer part : parts) {
            HashSet<Integer> newDp = new HashSet<>(dp);
            for (Integer i : dp) {
                newDp.add(i + part);
            }
            dp = newDp;
        }

        System.out.println(dp.size());
    }
}
