package com.classic150;

public class BitCalc {

    /**
     * No. 67 二进制求和
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >=0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }

    /**
     *
     * @param n n 表示一个 32 位无符号整数的二进制位
     * @return 返回颠倒的二进制位数
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= (n & 1) << (32 - i);
            n >>>= 1;
        }
        return res;
    }

    /**
     * No. 191 位 1 的个数
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i < 31; i++) {

            if ((1 & n) == 1) {
                count++;
            }

           n = n >> 1;
        }
        return count;
    }

    /**
     * No. 136 只出现一次的数字
     * 异或运算符(^)，两个相同的数字异或会相互抵消
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

}
