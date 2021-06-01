package stack;

import java.util.Stack;

/**
 * Created by zjm on 2021/4/12 21:25
 */
public class MaxStack {

    //存数据所用
    Stack<Integer> stack;
    //辅助栈，记录最大值
    Stack<Integer> max;

    public MaxStack() {
        stack = new Stack();
        max = new Stack();
    }

    public void push(int x) {
        stack.push(x);
        if(max.isEmpty() || max.peek() <= x) {
            max.push(x);
        }
    }

    public void pop() {
        int x = stack.pop();
        if(max.peek() == x) {
            max.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMax() {
        return max.peek();
    }

    //测试用例
    public static void main(String[] args) {
        MaxStack ms = new MaxStack();
        ms.push(3);
        ms.push(7);
        ms.push(9);
        ms.push(1);
        System.out.println(ms.getMax());
        ms.pop();
        System.out.println(ms.getMax());
        ms.pop();
        System.out.println(ms.getMax());
        ms.pop();
        System.out.println(ms.getMax());
        ms.push(2);
        ms.push(5);
        System.out.println(ms.getMax());
        ms.pop();
        System.out.println(ms.getMax());
        ms.pop();
        System.out.println(ms.getMax());
    }
}
