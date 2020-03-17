package stack;

import java.util.Stack;

/**
 * 155 MinStack
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Created by zjm on 2020/3/17 22:58
 */
public class MinStack {

    Stack<Integer> s;
    Stack<Integer> m;

    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack();
        m = new Stack();
    }

    public void push(int x) {
        s.push(x);
        if(m.isEmpty() || m.peek() >= x) {
            m.push(x);
        }
    }

    public void pop() {
        int x = s.pop();
        if(m.peek() == x) {
            m.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return m.peek();
    }

    Stack<Integer> stack;
    int min;

    /** initialize your data structure here. */
    public MinStack(int m) {
        stack = new Stack();
        min = Integer.MAX_VALUE;
    }

    public void push1(int x) {
        if(min >= x) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop1() {
        int x = stack.pop();
        if(min == x) {
            min = stack.pop();
        }
    }

    public int top1() {
        return stack.peek();
    }

    public int getMin1() {
        return min;
    }
}
