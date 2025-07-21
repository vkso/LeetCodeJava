package HWOD.niuke;
import java.util.*;

public class hj95 {
    static int n, m, q; // n 表示行数，m 表示列数，q 表示计划数量
    static char[][] land; // 表示草地的二维字符数组
    static char[][][] plans; // 三维数组，存储每个计划的二维矩阵
    static int minPlanCount = Integer.MAX_VALUE; // 当前找到的最少计划数，初始化为最大值
    static List<Integer> bestPlanSet = new ArrayList<>(); // 存储当前找到的最优计划组合编号

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 输入读取对象
        n = sc.nextInt(); // 读取草地的行数
        m = sc.nextInt(); // 读取草地的列数
        q = sc.nextInt(); // 读取计划的数量
        sc.nextLine(); // 读取换行符

        land = new char[n][m]; // 初始化草地图
        for (int i = 0; i < n; i++) {
            land[i] = sc.nextLine().toCharArray(); // 每行输入转成字符数组
        }

        plans = new char[q][n][m]; // 初始化所有计划的数组
        for (int k = 0; k < q; k++) { // 遍历每个计划
            for (int i = 0; i < n; i++) {
                plans[k][i] = sc.nextLine().toCharArray(); // 读取该计划的每一行
            }
        }

        // 枚举所有可能的子集组合（最多 2^q 种）
        for (int mask = 0; mask < (1 << q); mask++) {
            if (check(mask)) { // 检查该组合是否满足条件
                int count = Integer.bitCount(mask); // 统计当前子集中包含的计划数
                if (count < minPlanCount) { // 如果比当前记录的更少
                    minPlanCount = count; // 更新最小值
                    bestPlanSet.clear(); // 清空之前记录的最优解
                    for (int i = 0; i < q; i++) {
                        if ((mask & (1 << i)) != 0) { // 如果 mask 中第 i 位是 1
                            bestPlanSet.add(i + 1); // 加入编号（编号从 1 开始）
                        }
                    }
                }
            }
        }

        // 输出结果
        if (minPlanCount == Integer.MAX_VALUE) {
            System.out.println(-1); // 没有满足条件的方案
        } else {
            System.out.println(minPlanCount); // 输出使用的最少计划数
            for (int i = 0; i < bestPlanSet.size(); i++) {
                System.out.print(bestPlanSet.get(i)); // 输出计划编号
                if (i < bestPlanSet.size() - 1) System.out.print(" "); // 添加空格
            }
        }
    }

    // 检查 mask 表示的计划组合是否满足题目条件
    static boolean check(int mask) {
        for (int i = 0; i < n; i++) { // 遍历每一行
            for (int j = 0; j < m; j++) { // 遍历每一列
                boolean firework = false; // 标记当前格子是否被点燃烟花
                for (int k = 0; k < q; k++) { // 遍历所有计划
                    if ((mask & (1 << k)) != 0 && plans[k][i][j] == '1') {
                        firework = true; // 只要有一个计划点燃了该位置，就标记为 true
                        break;
                    }
                }

                if (land[i][j] == '1' && firework) return false; // 杂物处不能点燃烟花
                if (land[i][j] == '0' && !firework) return false; // 空地必须点燃烟花
            }
        }
        return true; // 所有格子都满足要求
    }
}
