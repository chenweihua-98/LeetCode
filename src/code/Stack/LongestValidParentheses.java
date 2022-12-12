package code.Stack;

import java.util.Stack;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：IongestValidParentheses
 * 类 描 述：TODO
 * 创建时间：2022/12/5 上午11:14
 * 创 建 人：chenweihua
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i =0;i<s.length();++i){
            if (s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }
                maxans = Math.max(maxans,i-stack.peek());
            }
        }
        return maxans;
    }
}
