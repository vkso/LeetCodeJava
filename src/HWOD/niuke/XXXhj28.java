package HWOD.niuke;

import java.util.Arrays;
import java.util.Scanner;

public class XXXhj28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int count = 0;
        boolean[] isVisited = new boolean[n];

        for (int i = 0; i < array.length - 1; i++) {

            if (isVisited[i]) {
                continue;
            }

            for (int j = i + 1; j < array.length; j++) {
                if (isVisited[j]) {
                    continue;
                }
                if (isSushu(array[i] + array[j])) {
                    isVisited[i] = true;
                    isVisited[j] = true;
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }

    public static boolean isSushu(int n) {
        double sqrt = Math.sqrt((double) n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
