package HWOD.Problem20最少交换次数;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Problem20 {
    /**
     * 最少交换次数
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int K = sc.nextInt();

        HashSet<Integer> set = new HashSet<>();

        // 统计可能需要交换的数字的下标到一个集合中
        for (int i = 0; i < array.length; i++) {
            if (array[i] < K) {
                set.add(i);
            }
        }

        int res = Integer.MAX_VALUE;

        int left = 0, right = set.size() - 1;
        while (right < array.length) {

            int count = 0;

            for (int i = left; i <= right; i++) {
                if (!set.contains(i)) {
                    count++;
                }
            }

            res = Math.min(res, count);

            left++;
            right++;
        }

        System.out.println(res);
    }
}
