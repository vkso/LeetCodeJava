package com.swordoffer;

import com.leetcode.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    private List<Integer> list;
    private int curIndex;

    public BSTIterator(TreeNode root) {
        curIndex = 0;
        this.list = new ArrayList<>();
        inOrder(root);
    }

    public int next() {
        return list.get(curIndex++);
    }

    public boolean hasNext() {
        return curIndex < list.size();
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}

