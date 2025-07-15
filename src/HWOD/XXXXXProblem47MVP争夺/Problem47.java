package HWOD.XXXXXProblem47MVP争夺;

import java.util.*;

public class Problem47 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        // 分数数组
        int[] nums = new int[t];
        // 总分数之和
        int sum = 0;

        for (int i = 0; i < t; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }

        Arrays.sort(nums);

        // 最差情况，一个人得了全部的分数
        System.out.println(sum);
    }

    static boolean canPartition(int[] nums, int k, int target) {
        int[] buckets = new int[k];
        return dfs(nums, nums.length - 1, buckets, target) ;
    }

    static boolean dfs(int[] nums, int idx, int[] buckets, int target) {
        if (idx < 0) return true;

        int val = nums[idx];
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] + val > target) continue;
            buckets[i] += val;
            if (dfs(nums, idx - 1, buckets, target)) return true;
            buckets[i] -= val;
            // 剪枝
            if (buckets[i] == 0) break;
        }
        return false;
    }
}
