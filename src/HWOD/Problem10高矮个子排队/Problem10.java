package HWOD.Problem10高矮个子排队;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Problem10 {
    /**
     * 高矮个子排队问题
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heights = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int i = 0, j = 1;  // 初始化两个指针，i 和 j，分别指向相邻的两个小朋友

        while (j < heights.length) {
            // 判断相邻两个小朋友身高是否满足要求
            // 如果 heights[i] > heights[j] 且 i 是偶数，或者 heights[i] < heights[j]且 j 是奇数
            // 则需要交换 heights[i] 和 heights[j] 的值，以符合“高矮交替”的规则
            if (heights[i] != heights[j] && (heights[i] > heights[j]) != (i % 2 == 0)) {
                int temp = heights[i];
                heights[i] = heights[j];
                heights[j] = temp;
            }

            i++;
            j++;
        }

        StringJoiner stringJoiner = new StringJoiner(" ");
        for (int height : heights) {
            stringJoiner.add(String.valueOf(height));
        }
        System.out.println(stringJoiner.toString());
    }
}
