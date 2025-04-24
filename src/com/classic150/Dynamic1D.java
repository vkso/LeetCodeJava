package com.classic150;

public class Dynamic1D {
    /**
     * No. 70 爬楼梯
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        // 滚动数组的思想，将 O(n) 的空间复杂度，转换为 O(1)
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
