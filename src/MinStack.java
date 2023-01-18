import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * No. 155 最小栈
 *     Tips: 维护一个辅助栈，用来存放当前元素对应的已经入栈的最小元素
 */
public class MinStack {
    public Deque<Integer> stack;
    public Deque<Integer> miniStack;
    public MinStack() {
        stack = new LinkedList<>();
        miniStack = new LinkedList<>();
        miniStack.push(Integer.MAX_VALUE);

    }

    public void push(int val) {
        stack.push(val);
        miniStack.push(Math.min(miniStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        miniStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return miniStack.peek();
    }
}
