package com.classic150;

import java.util.*;

public class TwoPointer {

    /**
     * 125. 验证回文串
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        // 将字符串大写字符转换为小写字符
        String lowerCase = s.toLowerCase();

        // 移除所有的非字母数字字符
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lowerCase.length(); i++) {
            char ch = lowerCase.charAt(i);
            if (ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
                sb.append(ch);
            }
        }

        String newStr = sb.toString();
        if (newStr == null) {
            return true;
        }

        for (int i = 0, j = newStr.length() - 1; i < j; i++, j--) {
            if (newStr.charAt(i) == newStr.charAt(j)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindromeX(String s) {
        StringBuffer sb = new StringBuffer();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }

        StringBuffer reverseSB = new StringBuffer(sb).reverse();
        return sb.toString().contentEquals(reverseSB);
    }

    /**
     * 392. 判断子序列
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen == 0) {
            return true;
        }

        if (tLen == 0) {
            return false;
        }

        int sCur = 0, tCur = 0;

        while (sCur < sLen && tCur < tLen) {
            if (s.charAt(sCur) == t.charAt(tCur)) {
                sCur++;
            }
            tCur++;
        }

        return sCur == sLen;
    }

    /**
     * No. 167 两数之和 II - 输入有序数组
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (sum == target) {
                    return new int[]{i + 1, j + 1};
                } else if (sum > target) {
                    break;
                }
            }
        }
        return new int[]{0, 0};
    }

    public int[] twoSumX(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{0, 0};
    }

    /**
     * No. 11 盛最多水的容器
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            res = Math.max((right - left) * Math.min(height[left], height[right]), res);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    /**
     * No. 15 三数之和
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = n - 1;
            int target = -nums[first];

            for (int sencond = first + 1; sencond < n; sencond++) {
                if (sencond > first + 1 && nums[sencond] == nums[sencond - 1]) {
                    continue;
                }
                while (sencond < third && nums[sencond] + nums[third] > target) {
                    --third;
                }
                if (sencond == third) {
                    break;
                }
                if (nums[sencond] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[sencond]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

}
