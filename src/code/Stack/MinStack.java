package code.Stack;

import java.util.Stack;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：MinStack
 * 类 描 述：TODO 力扣题155
 * 创建时间：2022/10/18 下午3:53
 * 创 建 人：chenweihua
 */
public class MinStack {

    public Stack<Integer> data;
    public Stack<Integer> helper;

    public MinStack(){
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int val){
        data.push(val);
        if (helper.isEmpty()||helper.peek()>=val){
            helper.push(val);
        }else {
            helper.push(helper.peek());
        }
    }

    public void pop(){
        data.pop();
        helper.pop();
    }

    public int top(){
        return data.peek();
    }

    public int getMin(){
        return  helper.peek();
    }


}
