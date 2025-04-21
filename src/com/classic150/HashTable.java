package com.classic150;

import java.util.*;

public class HashTable {

    /**
     * No. 383 赎金信
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            Integer count = map.getOrDefault(ch, 0);
            if (count == 0) {
                return false;
            } else {
                map.put(ch, count - 1);
            }
        }

        return true;
    }

    /**
     * No. 205 同构字符串
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch_s = s.charAt(i);
            char ch_t = t.charAt(i);
            Character value = map.getOrDefault(ch_s, null);

            if (value == null) {  // 需要判断建立的映射关系，是否已经被其他字符占用了，如果被占用了，返回 false，如果没被占用，则建立映射关系
                if (set.contains(ch_t)) {
                    return false;
                } else {
                    map.put(ch_s, ch_t);
                    set.add(ch_t);
                }
            } else {
                if (value != ch_t) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * No. 290 单词规律
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        HashMap<String, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        if (words.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            Character pattern_ch = pattern.charAt(i);
            String word = words[i];

            Character value = map.getOrDefault(word, null);
            if (value == null) {
                if (set.contains(pattern_ch)) {
                    return false;
                }
                map.put(word, pattern_ch);
                set.add(pattern_ch);
            } else {
                if (value != pattern_ch) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * No. 242 有效的字母异位词
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        for (int j = 0; j < t.length(); j++) {
            char ch = t.charAt(j);
            Integer value = count.getOrDefault(ch, -1);

            if (value > 0) {
                if (value - 1 == 0) {
                    count.remove(ch);
                } else {
                    count.put(ch, value - 1);
                }
            } else {
                return false;
            }
        }

        return count.isEmpty();
    }

    /**
     * No. 1 两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            Integer orDefault = map.getOrDefault(value, null);
            if (orDefault == null) {
                map.put(nums[i], i);
            } else {
                res[0] = i;
                res[1] = orDefault;
            }
        }
        return res;
    }

    /**
     * No. 202 快乐数
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int calc = n;

        while (true) {
            String numStr = Integer.toString(calc);
            int squareSum = 0;
            for (int i =0; i < numStr.length(); i++) {
                char ch = numStr.charAt(i);
                squareSum += (ch - 48) * (ch - 48);
            }
            if (squareSum == 1) {
                return true;
            }

            if (set.contains(squareSum)) {
                return false;
            } else {
                set.add(squareSum);
                calc = squareSum;
            }
        }
    }

    /**
     * No. 219 存在重复元素 II
     * 优化思路：如下方法，会重复计算已经计算过的数据（因为 put 进去的数据，都是计算过的，没有符合要求，没有 return），因此，只需要将最新
     * 的 index 索引覆盖该数据即可
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> integerListHashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (integerListHashMap.containsKey(nums[i])) {
                List<Integer> integers = integerListHashMap.get(nums[i]);
                for (Integer integer : integers) {
                    if (Math.abs(i - integer) <= k) {
                        return true;
                    }
                }
                integers.add(i);
            } else {
                List<Integer> integers = new ArrayList<>();
                integers.add(i);
                integerListHashMap.put(nums[i], integers);
            }
        }
        return false;
    }










}
