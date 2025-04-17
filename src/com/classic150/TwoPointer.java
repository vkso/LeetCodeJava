package com.classic150;

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
}
