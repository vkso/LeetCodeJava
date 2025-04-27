package com.classic150;

import org.junit.Test;

import javax.security.auth.callback.CallbackHandler;
import java.util.HashSet;

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

}
