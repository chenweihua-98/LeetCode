package code.Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：MyStack
 * 类 描 述：TODO 力扣题225 用队列实现栈 队列实行先进先出，栈后进先出
 * 创建时间：2022/10/17 下午3:20
 * 创 建 人：chenweihua
 */
public class MyStack {

    Queue<Integer> queue;

    public void myStack(){
        queue = new LinkedList<Integer>();
    }


    public void push(int x){
        int n = queue.size();
        queue.offer(x);
        //根据队列先进先出将x前面的所有元素都取出来则x元素排在最前面，然后将后续元素一次放入
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }


    public int pop(){
        return  queue.poll();
    }

    public int top(){
        return queue.peek();
    }

    public  boolean empty(){
        return queue.isEmpty();
    }

}
