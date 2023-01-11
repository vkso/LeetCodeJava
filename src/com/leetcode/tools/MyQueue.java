package com.leetcode.tools;

import java.util.Stack;

/**
 * 使用两个栈实现队列的基本操作（push、pop、peak、empty）
 */
public class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
    }

    public void push(int x) {
        int move;
        while (! stack2.empty()) {
            move = stack2.pop();
            stack1.push(move);
        }
        stack1.push(x);
        while (! stack1.empty()) {
            move = stack1.pop();
            stack2.push(move);
        }
    }

    public int pop() {
        return stack2.pop();
    }

    public int peek() {
        return stack2.peek();
    }

    public boolean empty() {
        if (stack2.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
