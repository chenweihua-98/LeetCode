package code.Stack;

import java.util.Stack;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：MyQueue
 * 类 描 述：TODO 力扣题232用栈实现队列请你仅使用两个栈实现先入先出队列。
 *          队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 创建时间：2022/10/19 下午2:03
 * 创 建 人：chenweihua
 */
public class MyQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.push(x);
    }

    public int pop() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return stack1.pop();
    }

    public int peek() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }


}
