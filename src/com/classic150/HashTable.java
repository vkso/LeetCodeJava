package com.classic150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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


}
