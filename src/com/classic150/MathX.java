package com.classic150;

import java.util.ArrayList;

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

    /**
     * No. 66 加一
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int push = 1;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = digits.length - 1; i >= 0; i--) {
            push += digits[i];
            res.add(push % 10);
            push /= 10;
        }

        if (push == 1) {
            res.add(1);
        }

        int[] ints = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            ints[i] = res.get(res.size() - 1 - i);
        }

        return ints;
    }

    /**
     * No. 69 x 的平方根
     * 使用二分查找，找到最接近的 a, a * a < x; (a + 1) * (a + 1) > x
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
