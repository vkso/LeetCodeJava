package HWOD.niuke;

import java.util.Arrays;
import java.util.Scanner;

public class XXXhj67 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] visit = new int[4];
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            visit[i] = 1;
            if (dfs(nums, visit, nums[i])) {
                flag = true;
                break;
            }
        }
        System.out.println(flag);
    }

    public static boolean dfs(int[] nums, int[] visit, int temp) {
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                if (dfs(nums, visit, temp + nums[i])
                || dfs(nums, visit, temp - nums[i])
                || dfs(nums, visit, temp * nums[i])
                || (temp % nums[i] == 0 && dfs(nums, visit, temp / nums[i]))) {
                    return true;
                }
                visit[i] = 0;
            }
        }

        if (temp == 24) {
            return true;
        }
        return false;
    }
}
