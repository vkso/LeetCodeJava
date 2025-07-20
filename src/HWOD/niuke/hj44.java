package HWOD.niuke;

import java.util.Scanner;

public class hj44 {
    static int[][] board = new int[9][9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 输入数独矩阵
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // 求解
        solveSudoku();

        // 输出
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
                if (j < 8) System.out.print(" ");
            }
            System.out.println();
        }
    }

    // 回溯解法
    public static boolean solveSudoku() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    // 尝试填入数字 1~9
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku()) return true; // 递归
                            board[row][col] = 0; // 回溯
                        }
                    }
                    return false; // 无法填入合法数字，回溯
                }
            }
        }
        return true; // 已填满
    }

    // 判断 (row,col) 位置填入 num 是否合法
    public static boolean isValid(int row, int col, int num) {
        // 检查行
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }

        // 检查列
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // 检查 3x3 宫格
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }
}
