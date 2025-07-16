package HWOD.realTask.Problem07接口成功率;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Problem07 {
    /**
     * 查找接口成功率最优时间段
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int minAverageLost = sc.nextInt();
        sc.nextLine();
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] prefixArray = new int[array.length + 1];
        for (int i = 1; i < prefixArray.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + array[i - 1];
        }

        ArrayList<String> resultList = new ArrayList<>();
        int maxLength = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int length = j - i + 1;
                int sum = prefixArray[j + 1] - prefixArray[i];

                // 如果当前区间的值比最低容忍区间小
                if (sum <= minAverageLost * length) {
                    if (length > maxLength) {
                        maxLength = length;
                        resultList.clear();
                        resultList.add(i + "-" + j);
                    } else if (length == maxLength) {
                        resultList.add(i + "-" + j);
                    }
                }
            }
        }

        if (resultList.isEmpty()) {
            System.out.println("NULL");
        } else {
            Collections.sort(resultList, (a, b) -> {
                int aStart = Integer.parseInt(a.split("-")[0]);
                int bStart = Integer.parseInt(b.split("-")[0]);
                return aStart - bStart;
            });

            StringBuilder sb = new StringBuilder();
            for (String s : resultList) {
                sb.append(s).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}