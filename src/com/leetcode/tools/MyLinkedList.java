package com.leetcode.tools;

public class MyLinkedList {
    public ListNode head = null;
    public int length = 0;

    public MyLinkedList(ListNode head) {
        this.head = head;
    }

    public MyLinkedList(int[] nums) {
        this.length = nums.length;
        ListNode head_pre = new ListNode();
        ListNode head_move = head_pre;
        for (int i = 0; i < length; i++) {
            head_move.next = new ListNode(nums[i]);
            head_move = head_move.next;
        }
        head = head_pre.next;
    }

    public void show() {
        ListNode move = head;
        System.out.print("[");
        while (move.next != null) {
            System.out.print(move.val + ", ");
            move = move.next;
        }
        System.out.println(move.val + "]");
    }

    public int getLength() {
        return length;
    }

    public ListNode getHead() {
        return head;
    }
}
