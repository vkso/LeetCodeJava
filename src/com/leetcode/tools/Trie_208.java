package com.leetcode.tools;

public class Trie_208 {
    Trie_208[] child;
    private boolean isEnd;
    public Trie_208() {
        this.child = new Trie_208[26];
        this.isEnd = false;
    }

    public void insert(String word) {
        Trie_208 node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.child[index] == null) {
                node.child[index] = new Trie_208();
            }
            node = node.child[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie_208 node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.child[index] == null) {
                return false;
            }
            node = node.child[index];
        }
        return node.isEnd == true;
    }

    public boolean startsWith(String prefix) {
        Trie_208 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.child[index] == null) {
                return false;
            }
            node = node.child[index];
        }
        return true;
    }
}
