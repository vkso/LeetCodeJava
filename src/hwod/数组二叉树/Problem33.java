package hwod.数组二叉树;

import java.util.Arrays;
import java.util.Scanner;

public class Problem33 {
    /**
     * 数组二叉树
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        int len = array.length;

        for (int i = 0; i < len; i++) {

            if (array[i] == -1) {
                continue;
            }

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left >= len && right >= len || (array[left] == -1 && array[right] == -1)) {
                if (array[i] < minValue) {
                    minValue = array[i];
                    minIndex = i;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (minIndex >= 0) {
            sb.append(array[minIndex]).append(" ");

            if (minIndex == 0) {
                break;
            }

            minIndex = (minIndex - 1) / 2;
        }

        System.out.println(sb.reverse().toString().trim());
    }
}
