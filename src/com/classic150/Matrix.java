package com.classic150;

import org.junit.Test;

import javax.security.auth.callback.CallbackHandler;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Matrix {

    /**
     * No. 36 有效的数独
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        boolean row = judgeRow(board);
        boolean col = judgeCow(board);
        boolean inner = judgeInner(board);

        if (!(row && col && inner)) {
            return false;
        }
        return true;
    }

    /**
     * @param board 矩阵
     * @return true or false
     */
    public boolean judgeRow(char[][] board) {
        int n = board.length;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.clear();
            for (int j = 0; j < n; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }
                if (ch >= '0' && ch <= '9' && !set.contains(ch)) {
                    set.add(ch);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @param board 矩阵
     * @return true or false
     */
    public boolean judgeCow(char[][] board) {
        int n = board.length;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.clear();
            for (int j = 0; j < n; j++) {
                char ch = board[j][i];
                if (ch == '.') {
                    continue;
                }
                if (ch >= '0' && ch <= '9' && !set.contains(ch)) {
                    set.add(ch);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean judgeSquare(char[][] board, int x, int y) {
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }
                if (ch >= '0' && ch <= '9' && !set.contains(ch)) {
                    set.add(ch);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean judgeInner(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j += 3) {
                if (!judgeSquare(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        boolean validSudoku = isValidSudoku(board);
    }

    /**
     * No. 73 矩阵置零
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n= matrix[0].length;
        HashSet<Integer> setRow = new HashSet<>();
        HashSet<Integer> setCow = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    setRow.add(i);
                    setCow.add(j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (setRow.contains(i) || setCow.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * No. 54 螺旋矩阵
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        int[][] mark = new int[m][n];

        int i = 0, j = 0;
        int count = 0;
        int flg = 0;
        while (count < m * n) {
            flg = flg % 4;
            switch (flg) {
                case 0: {
                    // 向右遍历
                    while (j < n && mark[i][j] == 0) {
                        res.add(matrix[i][j]);
                        mark[i][j] = 1;
                        j++;
                        count++;
                    }
                    j--;
                    i++;
                    flg++;
                    break;
                }
                case 1: {
                    // 向下遍历
                    while (i < m && mark[i][j] == 0) {
                        res.add(matrix[i][j]);
                        mark[i][j] = 1;
                        i++;
                        count++;
                    }
                    i--;
                    j--;
                    flg++;
                    break;
                }
                case 2: {
                    // 向左遍历
                    while (j > -1 && mark[i][j] == 0) {
                        res.add(matrix[i][j]);
                        mark[i][j] = 1;
                        j--;
                        count++;
                    }
                    j++;
                    i--;
                    flg++;
                    break;
                }
                case 3: {
                    // 向上遍历
                    while (i > -1 && mark[i][j] == 0) {
                        res.add(matrix[i][j]);
                        mark[i][j] = 1;
                        i--;
                        count++;
                    }
                    i++;
                    j++;
                    flg++;
                    break;
                }
            }
        }
        return res;
    }

    @Test
    public void testx() {
        int[][] matrix = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife(matrix);
    }

    /**
     * No. 48 旋转图像
     * 1. 水平翻转
     * 2. 主对角线翻转
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 水平翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }

        // 主对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * No. 289 生命游戏
     * count < 2        1 -> 0
     * 2 <= count <= 3  1 -> 1
     * count > 3        1 -> 0
     * count == 3       0 -> 1
     * @param board
     */
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] clone = new int[m][];

        for (int i = 0; i < m; i++) {
            clone[i] = board[i].clone();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = clone[i][j];
                int count = count(clone, i, j);
                if (value == 0) {
                    if (count == 3) {
                        board[i][j] = 1;
                    }
                } else {
                    if (count < 2) {
                        board[i][j] = 0;
                    } else if (count <= 3) {
                        continue;
                    } else if (count > 3) {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    public int count(int[][] board, int x, int y) {
        int res = 0;
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (i == x && j == y) {
                    continue;
                }
                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                    res += board[i][j];
                }
            }
        }
        return res;
    }

}
