package HWOD.niuke;

import java.util.Scanner;

public class hj35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

         matrix[0][0] = 1;

         int step = 2;
         for (int i = 1; i < n; i++) {
             matrix[0][i] = matrix[0][i - 1] + step;
             step++;
         }

         for (int i = 1; i < n; i++) {
             fillLine(matrix, 0, i);
         }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    continue;
                }
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void fillLine(int[][] matrix, int startRow, int startCol) {
        int n = matrix.length;
        int row = startRow;
        int col = startCol;
        int startNum = matrix[row][col];

        while (row + 1 < n && col - 1 >= 0) {
            row++;
            col--;

            matrix[row][col] = --startNum;
        }
    }
}
