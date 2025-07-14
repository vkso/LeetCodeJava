package HWOD.Problem23虚拟理财游戏;

import java.util.Scanner;

public class Problem23 {
    /**
     * 虚拟理财游戏
     * 5 100 10 (产品数 总投资额 总风险)
     * 10 20 30 40 50 (产品投资回报率序列)
     * 3 4 5 6 10 (产品风险序列)
     * 20 30 20 40 30 (最大投资额度)
     *
     * 投资回报 = 投资额 * 回报率
     *
     * 可以投资一个或投资两个，这两种情况都需要考虑
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int productsNum = sc.nextInt();
        int totalMoney = sc.nextInt();
        int totalDanger = sc.nextInt();

        int[] reportArray = new int[productsNum];
        int[] dangerArray = new int[productsNum];
        int[] maxEduArray = new int[productsNum];

        for (int i = 0; i < productsNum; i++) {
            reportArray[i] = sc.nextInt();
        }

        for (int i = 0; i < productsNum; i++) {
            dangerArray[i] = sc.nextInt();
        }

        for (int i = 0; i < productsNum; i++) {
            maxEduArray[i] = sc.nextInt();
        }

        int maxReturn = 0;
        int[] bestSolution = new int[productsNum];

        // 只投资一个的情况
        for (int i = 0; i < productsNum; i++) {
            if (dangerArray[i] > totalDanger) {
                continue;
            }

            int[] current = new int[productsNum];
            // 分配最大额度
            current[i] = Math.min(totalMoney, maxEduArray[i]);
            int currentReturn = current[i] * reportArray[i];

            if (currentReturn > maxReturn) {
                maxReturn = currentReturn;
                bestSolution = current;
            }
        }

        // 投资两个产品的情况
        for (int i = 0; i < productsNum; i++) {
            for (int j = i + 1; j < productsNum; j++) {
                // 计算总风险
                int totalRisk = dangerArray[i] + dangerArray[j];
                if (totalRisk > totalDanger) continue;

                // 定义当前遍历的额度分配数组
                int[] current = new int[productsNum];
                // 根据两个项目回报率的高低进行分配
                if (reportArray[i] >= reportArray[j]) {
                    // 先分配给回报率更高的产品 i
                    current[i] = Math.min(totalMoney, maxEduArray[i]);
                    // 剩余额度分配给产品 j
                    current[j] = Math.min(maxEduArray[j], totalMoney - current[i]);
                } else {
                    // 先分配给回报率更高的产品 j
                    current[j] = Math.min(totalMoney, maxEduArray[j]);
                    current[i] = Math.min(maxEduArray[i], totalMoney - current[j]);
                }

                int currentReturn = current[i] * reportArray[i] + current[j] * reportArray[j];

                // 计算总回报率
                if (currentReturn > maxReturn) {
                    maxReturn = currentReturn;
                    bestSolution = current;
                }
            }
        }

        // 输出结果
        for (int i = 0; i < productsNum; i++) {
            System.out.print(bestSolution[i]);
            if (i < productsNum - 1) {
                System.out.print(" ");
            }
        }
    }
}
