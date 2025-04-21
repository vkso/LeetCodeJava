package com.classic150;

import java.util.ArrayDeque;
import java.util.HashSet;

public class Stack {

    /**
     * No. 20 有效的括号
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        String leftP = "({[";

        HashSet<String> set = new HashSet<>();
        set.add("{}");
        set.add("()");
        set.add("[]");

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (leftP.indexOf(ch) > -1) {
                stack.push(ch);
            } else {
                if (!stack.isEmpty()) {
                    Character pop = stack.pop();

                    StringBuffer sb = new StringBuffer();
                    sb.append(pop);
                    sb.append(ch);

                    if (!set.contains(sb.toString())) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
