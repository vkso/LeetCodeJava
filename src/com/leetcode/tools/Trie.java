package com.leetcode.tools;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    public int ref;
    public Map<String, Trie> children;

    public Trie() {
        this.ref = -1;
        this.children= new HashMap<>();
    }
}