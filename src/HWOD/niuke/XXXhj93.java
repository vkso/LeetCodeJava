package HWOD.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XXXhj93 {
    static List<Integer> freeList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        int sumA = 0, sumB = 0;
        for (int num : nums) {
            if (num % 5 == 0) {
                sumA += num;
            } else if (num % 3 == 0) {
                sumB += num;
            } else {
                freeList.add(num); // 可自由分配的数
            }
        }

        boolean result = dfs(0, sumA, sumB);
        System.out.println(result ? "true" : "false");
    }

    // 尝试将剩下的数加入 a 或 b，看是否能达到 aSum == bSum
    static boolean dfs(int index, int aSum, int bSum) {
        if (index == freeList.size()) {
            return aSum == bSum;
        }
        int num = freeList.get(index);
        // 尝试加入 a
        if (dfs(index + 1, aSum + num, bSum)) return true;
        // 尝试加入 b
        if (dfs(index + 1, aSum, bSum + num)) return true;

        return false;
    }
}
