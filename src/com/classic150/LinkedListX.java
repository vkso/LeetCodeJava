package com.classic150;

import com.leetcode.tools.ListNode;
import com.leetcode.tools.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LinkedListX {

    /**
     * No. 141 环形链表
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {

            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }

            head = head.next;
        }
        return false;
    }

    /**
     * 使用快慢指针的方法，理论上，如果存在环，那么快指针最终会追上慢指针，并指向同一个节点
     * @param head
     * @return
     */
    public boolean hasCycleX(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 不到链尾，不退出循环
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
        }
        return false;
    }

    public boolean hasCycleY(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        // 快慢指针不相遇，不退出循环
        while (slow != fast) {
            // 如果快指针到达链尾，那么一定无环
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * No. 2 两数相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int push = 0;
        ListNode res = new ListNode();
        ListNode cur = res;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + push;
            int value = sum % 10;

            cur.next = new ListNode(value);
            cur = cur.next;

            push = sum / 10;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + push;
            int value = sum % 10;
            cur.next = new ListNode(value);
            cur = cur.next;

            push = sum / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + push;
            int value = sum % 10;
            cur.next = new ListNode(value);
            cur = cur.next;

            push = sum / 10;
            l2 = l2.next;
        }

        if (push != 0) {
            cur.next = new ListNode(1);
        }

        return res.next;
    }

    /**
     * No. 21 合并两个有序链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode();
        ListNode res = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }

        if (list1 != null) {
            head.next = list1;
        }

        if (list2 != null) {
            head.next = list2;
        }

        return res.next;
    }

    /**
     * No. 138 随机链表的复制
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> nodeMap = new HashMap<>();
        Node current = head;
        while (current != null) {
            nodeMap.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        while (current != null) {
            nodeMap.get(current).next = nodeMap.get(current.next);
            nodeMap.get(current).random = nodeMap.get(current.random);
            current = current.next;
        }
        return nodeMap.get(head);
    }

}



















