package com.classic150;

import com.leetcode.tools.TreeNode;

public class BinarySearchTree {

    /**
     * No. 530 二叉搜索树的最小绝对差
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        ans_530 = Integer.MAX_VALUE;
        pre_530 = -1;
        midOrder(root);
        return ans_530;
    }

    int pre_530;
    int ans_530;

    public void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        midOrder(root.left);

        if (pre_530 == -1) {
            pre_530 = root.val;
        } else {
            ans_530 = Math.min(ans_530, root.val - pre_530);
            pre_530 = root.val;
        }

        midOrder(root.right);
    }



}
