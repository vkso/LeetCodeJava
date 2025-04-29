package com.classic150;

import org.junit.Test;

import java.util.*;

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

    /**
     * No. 30 串联所有单词的子串
     * 固定尺寸滑动窗口，一边滑动，一边统计新增、减少的单词，更新 HashMap，如果 HashMap 为空，则该位置的子
     * 串，符合题目所述的要求。
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int m = words.length, n = words[0].length(), ls = s.length();
        for (int i = 0; i < n; i++) {
            if (i + m * n > ls) {
                break;
            }
            Map<String, Integer> differ = new HashMap<String, Integer>();
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * n, i + (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            for (int start = i; start < ls - m * n + 1; start += n) {
                if (start != i) {
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - n, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }

    @Test
    public void testx() {
        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = {"fooo","barr","wing","ding","wing"};
        List<Integer> substring = findSubstring(s, words);
    }
}
