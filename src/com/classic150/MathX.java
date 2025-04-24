package com.classic150;

public class MathX {
    /**
     * No. 9 回文数
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String numStr = String.valueOf(x);

        int left = 0, right = numStr.length() - 1;
        while (left < right) {
            if (numStr.charAt(left) == numStr.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }
}
