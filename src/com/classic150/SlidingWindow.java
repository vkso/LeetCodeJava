package com.classic150;

import org.junit.Test;

import java.util.HashSet;

public class SlidingWindow {

    /**
     * No. 209 长度最小的子数组
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {    // 只要维护滑动窗口的右侧边界即可
            sum += nums[end];
            while (sum >= target) {    // 左边边界一直向右移动，直到结果不满足条件
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start++];
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * No. 3 无重复字符的最长子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        if (n == 0) {
            return 0;
        }

        int ans = Integer.MIN_VALUE;
        int start = 0, end = 0;
        HashSet<Character> set = new HashSet<>();
        while (end < n) {
            char ch = array[end];
            if (!set.contains(ch)) {
                set.add(ch);
                ans = Math.max(set.size(), ans);
                end++;
            } else {
                while (set.contains(ch)) {
                    char chr = array[start++];
                    set.remove(chr);
                }
            }
        }
        return ans;
    }
}
