package HWOD.realTask.Problem06补种胡杨树;

import java.util.Scanner;

public class Problem06 {
    /**
     * 补种未成活胡杨
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt();
        int deadCount = sc.nextInt();
        int[] nums = new int[total];

        for (int i = 0; i <deadCount ; i++) {
            int num = sc.nextInt();
            nums[num - 1] = 1; // 树的编号从 1 开始
        }

        int supplementCount = sc.nextInt();

        int left = 0;
        int maxLen = 0;
        int sumLeft = 0;
        int sumRight = 0;

        for (int right = 0; right < total; right++) {
            sumRight += nums[right];
            // 这个判断条件是整个算法的核心。也是两个 left、right 指针滑动窗口的计算核心
            while (sumRight - sumLeft > supplementCount) {
                sumLeft += nums[left];
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        System.out.println(maxLen);
    }
}
