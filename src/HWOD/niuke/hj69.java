package HWOD.niuke;

import java.util.Scanner;

public class hj69 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读入矩阵维度
        int x = sc.nextInt(); // A 的行数
        int y = sc.nextInt(); // A 的列数，也是 B 的行数
        int z = sc.nextInt(); // B 的列数

        // 读取矩阵 A（x 行 y 列）
        int[][] A = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // 读取矩阵 B（y 行 z 列）
        int[][] B = new int[y][z];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < z; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        // 结果矩阵 C（x 行 z 列）
        int[][] C = new int[x][z];

        // 计算矩阵乘法 C = A * B
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                int sum = 0;
                for (int k = 0; k < y; k++) {
                    sum += A[i][k] * B[k][j];
                }
                C[i][j] = sum;
            }
        }

        // 输出结果矩阵 C
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                System.out.print(C[i][j]);
                if (j < z - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
